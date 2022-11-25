package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;


 public class FicheiroUsuarios implements Serializable{
    static File dir = new File("");
    File db = new File("dbusers.dat");

    
    public void CaminhoPrincipal(){
      
      
        
        if(dir.exists()){
           System.out.print("Directorio OK!");
        }else{
            dir.mkdir();
        }
        
        if(db.exists()){
           System.out.print("Banco de dados OK!");
           
        }else{
            try {
                db.createNewFile();
                
                ArrayList<Usuario> lista = new ArrayList<Usuario>();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(db));
              
             

              objectOutputStream.writeObject(lista);
              
              objectOutputStream.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex, "", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex, "", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }

    public static boolean create(Usuario u){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
                 
        lista = (ArrayList<Usuario>) lista().clone();
        lista.add(u);
    
        try {
            File db = new File("dbusers.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(db));
            
        
            objectOutputStream.writeObject(lista);
            
            objectOutputStream.close();

            //System.out.println("Salvo com sucesso");
            return true;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao guardar o usuário!\n" + ex, "", JOptionPane.ERROR_MESSAGE);
        }
        
        return false;
    }
    
    public static ArrayList<Usuario> lista(){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
       
        
          try {
            
            FileInputStream readData = new FileInputStream("dbusers.dat");
            ObjectInputStream os = new ObjectInputStream(readData);
              
              lista = (ArrayList<Usuario>) os.readObject();
                   
             os.close();
              
          } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Ficheiro não encontrado!", "", JOptionPane.ERROR_MESSAGE);
          } catch (IOException ex) { 
                JOptionPane.showMessageDialog(null, "Erro: " + ex, "", JOptionPane.ERROR_MESSAGE);
          } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex, "", JOptionPane.ERROR_MESSAGE);
          }
        
          return lista;
        
    }   

 }
