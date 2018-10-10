/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limiariza_img;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author aluno1
 */
public class ManipulaImagem {

    public ManipulaImagem() {
    }
    
    public void colorToGreyScale(String caminho){
        try{
            //Leitura da Imagem Colorida
            BufferedImage imagem = ImageIO.read(new File(caminho));
            
            //Captura informações de largura e altura da imagem
            double image_width = imagem.getWidth();
            double image_height = imagem.getHeight();
            
            //Cria mais uma imagem no buffer
            BufferedImage bimg = null;
            
            // Especifica dimensões e que a nova imagem estará em escala de cinza
            bimg = new BufferedImage((int) image_width, (int) image_height, BufferedImage.TYPE_BYTE_GRAY);
            
            // Desenha a imagem colorida na nova imagem em cinza
            Graphics2D gg = bimg.createGraphics();
            gg.drawImage(imagem, 0, 0, imagem.getWidth(null), imagem.getHeight(null), null);
            
            // Salva a imagem em escala de cinza
            String temp = "bw_" + caminho;
            File fi = new File(temp);
            ImageIO.write(bimg, "jpg", fi);
            
            System.out.println("Feito!");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void binarizaImagem(String caminho, int t) {
        try{
            // Leitura da Imagem Colorida
            BufferedImage imagem = ImageIO.read(new File(caminho));
            
            //Define os valores para
            int BLACK = Color.BLACK.getRGB();
            int WHITE = Color.WHITE.getRGB();
            
            BufferedImage binaria = new BufferedImage(imagem.getWidth(), imagem.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
            
            // Percorre a imagem definido na saída o pixel como branco se o valor
            // na entrada for menor que o threshold, ou como preto se for maior.
            for (int y = 0; y < imagem.getHeight(); y++) {
                for (int x = 0; x < imagem.getWidth(); x++) {
                    Color pixel = new Color(imagem.getRGB(x, y));
                    
                    if (pixel.getBlue() < t)
                        binaria.setRGB(x, y, BLACK);
                    else binaria.setRGB(x, y, WHITE);
                }
                
                // Salva a imagem em escala de cinza
                String temp = "bin_" + caminho;
                File fi = new File(temp);
                ImageIO.write(binaria, "jpg", fi);
                
                System.out.println("Feito!");
            
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

