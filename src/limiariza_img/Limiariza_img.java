/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limiariza_img;

import javax.swing.JOptionPane;

/**
 *
 * @author aluno1
 */
public class Limiariza_img {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*ManipulaImagem imagem = new ManipulaImagem();
        int threshold;
        imagem.colorToGreyScale("curinga.jpeg");*/
        
        ManipulaImagem imagem = new ManipulaImagem();
        int threshold;
        imagem.colorToGreyScale("got2.jpg");
        
        /*ManipulaImagem img3 = new ManipulaImagem();
        int threshold3;
        imagem.colorToGreyScale("got2.jpg");*/
        
        do {
            threshold = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do tom de corte [0/255]:"));
            
            if ((threshold < 0) || (threshold > 255)){
                JOptionPane.showMessageDialog(null, "O valor do tom de corte deve ser entre 0 e 255", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while ((threshold < 0) || (threshold > 255));
        imagem.binarizaImagem("bw_got2.jpg", threshold);
        
       /* do {
            threshold2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do tom de corte [0/255]:"));
            
            if ((threshold < 0) || (threshold > 255)){
                JOptionPane.showMessageDialog(null, "O valor do tom de corte deve ser entre 0 e 255", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while ((threshold < 0) || (threshold > 255));
        imagem.binarizaImagem("bw_curinga.jpeg", threshold);
        
        do {
            threshold3 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor do tom de corte [0/255]:"));
            
            if ((threshold < 0) || (threshold > 255)){
                JOptionPane.showMessageDialog(null, "O valor do tom de corte deve ser entre 0 e 255", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while ((threshold < 0) || (threshold > 255));
        imagem.binarizaImagem("bw_curinga.jpeg", threshold);*/
    }
    
}
