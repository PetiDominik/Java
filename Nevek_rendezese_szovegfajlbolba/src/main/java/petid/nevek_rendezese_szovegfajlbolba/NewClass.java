/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petid.nevek_rendezese_szovegfajlbolba;

import java.io.File;
import java.io.RandomAccessFile;

/**
 *
 * @author petid
 */
public class NewClass {
    public static void main(String [] args){
        RandomAccessFile nevek = new RandomAccessFile("nevek.txt", "r");
        String sor;
        String[] sorok = null;
        int db = 0;
        
        for (sor = nevek.readLine(); sor != null; sor = nevek.readLine()){
            db++;
        }
        
        sorok = new String[db];
        
        db = 0; 
        nevek.seek(db);
        for (sor = nevek.readLine(); sor != null; sor = nevek.readLine()){
            sorok[db] = sor;
            db++;
        }
        
        File file = new File("rendezettnevek.txt");
        if (file.createNewFile()){
        }else{
            file.delete();
            file.createNewFile();
        }
        db = 0;
        for (String value : sorok){
            System.out.println("Sor" + (1*db+1) + ": " + sorok[db]);
            db++;
        }
        nevek.close();
        
        int i,j;
        String cs;
        
        for (i = 0; i<(sorok.length)-2; i++){
            for (j = i+1; j<(sorok.length)-1; j++){
                if (sorok[i].compareTo(sorok[j])>0){
                    cs = sorok[i];
                    sorok[i] = sorok[j];
                    sorok[j] = cs;
                }
            }
        }
        //Szólj ha görgessek valamerre
        RandomAccessFile abc = new RandomAccessFile("rendezettnevek.txt", "rw");
        
        for (i = 0; i < (sorok.length)-1; i++){
            System.out.println(sorok[i]);
            abc.writeBytes(sorok[i] + "\r\n");
        }
        
    }
}
