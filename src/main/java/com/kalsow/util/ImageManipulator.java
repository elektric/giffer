package com.kalsow.util;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.List;
import com.kalsow.model.PixelModel;

public class ImageManipulator {

    public int[][] convertTo2DWithoutUsingGetRGB(BufferedImage image) {

        final int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        final int width = image.getWidth();
        final int height = image.getHeight();
        final boolean hasAlphaChannel = image.getAlphaRaster() != null;

        int[][] result = new int[height][width];
        if (hasAlphaChannel) {
            final int pixelLength = 4;
            for (int pixel = 0, row = 0, col = 0; pixel + 3 < pixels.length; pixel += pixelLength) {
                int argb = 0;
                argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
                argb += ((int) pixels[pixel + 1] & 0xff); // blue
                argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
                result[row][col] = argb;
                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }
        } else {
            final int pixelLength = 3;
            for (int pixel = 0, row = 0, col = 0; pixel + 2 < pixels.length; pixel += pixelLength) {
                int argb = 0;
                argb += -16777216; // 255 alpha
                argb += ((int) pixels[pixel] & 0xff); // blue
                argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
                result[row][col] = argb;
                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }
        }

        return result;
    }

    public void rgb2lab(int R, int G, int B, int[] lab) {
        // http://www.brucelindbloom.com

        float r, g, b, X, Y, Z, fx, fy, fz, xr, yr, zr;
        float Ls, as, bs;
        float eps = 216.f / 24389.f;
        float k = 24389.f / 27.f;

        float Xr = 0.964221f; // reference white D50
        float Yr = 1.0f;
        float Zr = 0.825211f;

        // RGB to XYZ
        r = R / 255.f; // R 0..1
        g = G / 255.f; // G 0..1
        b = B / 255.f; // B 0..1

        // assuming sRGB (D65)
        if (r <= 0.04045)
            r = r / 12;
        else
            r = (float) Math.pow((r + 0.055) / 1.055, 2.4);

        if (g <= 0.04045)
            g = g / 12;
        else
            g = (float) Math.pow((g + 0.055) / 1.055, 2.4);

        if (b <= 0.04045)
            b = b / 12;
        else
            b = (float) Math.pow((b + 0.055) / 1.055, 2.4);


        X = 0.436052025f * r + 0.385081593f * g + 0.143087414f * b;
        Y = 0.222491598f * r + 0.71688606f * g + 0.060621486f * b;
        Z = 0.013929122f * r + 0.097097002f * g + 0.71418547f * b;

        // XYZ to Lab
        xr = X / Xr;
        yr = Y / Yr;
        zr = Z / Zr;

        if (xr > eps)
            fx = (float) Math.pow(xr, 1 / 3.);
        else
            fx = (float) ((k * xr + 16.) / 116.);

        if (yr > eps)
            fy = (float) Math.pow(yr, 1 / 3.);
        else
            fy = (float) ((k * yr + 16.) / 116.);

        if (zr > eps)
            fz = (float) Math.pow(zr, 1 / 3.);
        else
            fz = (float) ((k * zr + 16.) / 116);

        Ls = (116 * fy) - 16;
        as = 500 * (fx - fy);
        bs = 200 * (fy - fz);

        lab[0] = (int) (2.55 * Ls + .5);
        lab[1] = (int) (as + .5);
        lab[2] = (int) (bs + .5);
    }

    public List<PixelModel> getAverageOfPixelsForLEDMatrix(int[][] pixels, int width, int height) {
        int rows = pixels[0].length;
        int cols = pixels[1].length;

        int maxRows = (int) (rows / height);
        int maxCols = (int) (cols / width);
        int maxRowPixels = maxRows * height;
        int maxColPixels = maxCols * height;
        int pixelsPerAvgRow = maxRowPixels / height;
        int pixelsPerAvgCol = maxColPixels / width;
        int PixelsPerGroup = pixelsPerAvgRow * pixelsPerAvgCol;

        List<PixelModel> pixelModelList = new ArrayList<>();

        float r = 0;
        float g = 0;
        float b = 0;
        float a = 0;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int row = (i * pixelsPerAvgRow); row < (i + 1) * pixelsPerAvgRow; row++) {
                    for (int col = (j * pixelsPerAvgCol); col < (j + 1) * pixelsPerAvgCol; col++) {
                      int alpha = ((pixels[row][col] >> 24) & 0xff);
                      int red = ((pixels[row][col] >> 16) & 0xff);
                      int green = ((pixels[row][col] >> 8) & 0xff);
                      int blue = (pixels[row][col] & 0xff);
                      a += alpha * alpha;
                      r += red * red;
                      g += green * green;
                      b += blue * blue;
                    }
                }
                //1 section of pixels averaged
                PixelModel pm = new PixelModel((int) Math.sqrt(r / PixelsPerGroup),
                      (int) Math.sqrt(g / PixelsPerGroup), (int) Math.sqrt(b / PixelsPerGroup),
                      (int) Math.sqrt(a / PixelsPerGroup), i, j);
                pixelModelList.add(pm);
                r = 0;
                g = 0;
                b = 0;
                a = 0;
            }
        }

        return pixelModelList;

    }

}
