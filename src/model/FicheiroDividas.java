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


 public class FicheiroDividas implements Serializable{
    static File dir = new File("");
    File db = new File("dbdividas.dat");

    /**
     * Cria o ficheiro dos devedores ou verifica a sua existência no caminho indicado
     */
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
                
                ArrayList<Divida> lista = new ArrayList<Divida>();
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

    
    public static boolean create(Divida d){
        ArrayList<Divida> lista = new ArrayList<Divida>();
                 
        lista = (ArrayList<Divida>) lista().clone();
        lista.add(d);
    
        try {
            File db = new File("dbdividas.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(db));
            
        
            objectOutputStream.writeObject(lista);
            
            objectOutputStream.close();
            
            //System.out.println("Salvo com sucesso");
            return true;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex, "", JOptionPane.ERROR_MESSAGE);
        }
        
        return false;
    }    

    public static boolean edit(String id, Divida d){
        ArrayList<Divida> lista = new ArrayList<Divida>();
        
         lista= (ArrayList<Divida>) lista().clone();
         
        for (int i = 0; i < lista.size(); i++) {
            
            if(lista.get(i).getId().equals(id) || 
                    (lista.get(i).getNomeDevedor() + " " + lista.get(i).getApelidoDevedor()).equals(id)){
                
                lista.remove(i);
                lista.add(d);
            }
        }
        
          try {
              File db = new File("dbdividas.dat");
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(db));
              
            
              objectOutputStream.writeObject(lista);
              
              objectOutputStream.close();

              //System.out.println("Salvo com sucesso");
              return true;
              
          }  catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex, "", JOptionPane.ERROR_MESSAGE);
          }
          
          return false;
    }

    public static ArrayList<Divida> lista(){
        ArrayList<Divida> lista = new ArrayList<Divida>();
       
        
          try {
            
            FileInputStream readData = new FileInputStream("dbdividas.dat");
            ObjectInputStream os = new ObjectInputStream(readData);
              
              lista = (ArrayList<Divida>) os.readObject();
                   
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