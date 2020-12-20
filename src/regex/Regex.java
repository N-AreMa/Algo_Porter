
package regex;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.HashMap;
import java.io.*;
import java.util.regex.*;
import java.util.Scanner;
import java.util.*;
import java.util.StringTokenizer;


public class Regex {

  /*-------------Definicion de Constantes-------------*/
   
                    //Palabra o Letra
  private static final String PALETRA = "(a-z)*"; //abecedario.
  
  private static final String NUMEROS= "\\d";   //numeros del 0 al 9.
  
  private static final String ESPACIO= "\\b"; //Espacio en blanco.
     
  private static final String SIGNOS="\\p{Punct}";//Signos de puntuacion.
  
  //private static final String COMILLAS=" (\") "; //Comillas
 
  /*-------------------------- Tildes -------------------------*/
  
  private static final String TILDEA="(á|à)";
  private static final String CAMBIOA="a";

  private static final String TILDEE="[é|è]";
  private static final String CAMBIOE="e";

  private static final String TILDEI="[í|ì]";
  private static final String CAMBIOI="i";
  
  private static final String TILDEO="[ó|ò]";
  private static final String CAMBIOO="o";
  
  private static final String TILDEU="[ú|ù]";
  private static final String CAMBIOU="u";
  
/*-------------------------- Prefijos -------------------------*/
  
  private static final String PREF1= ESPACIO+"(an|a)"+PALETRA;
  private static final String PREF2= ESPACIO+"(ante)"+PALETRA;
  private static final String PREF3= ESPACIO+"(anti)"+PALETRA;
  private static final String PREF4= ESPACIO+"(bis|bi|biz)"+PALETRA;
  private static final String PREF5= ESPACIO+"(con|co)"+PALETRA;
  private static final String PREF6= ESPACIO+"(contra)"+PALETRA;
  private static final String PREF7= ESPACIO+"(des|de)"+PALETRA;
  private static final String PREF8= ESPACIO+"(en)"+PALETRA;
  private static final String PREF9= ESPACIO+"(entre|inter)"+PALETRA;
  private static final String PREF10= ESPACIO+"(ex)"+PALETRA;
  private static final String PREF11= ESPACIO+"(extra)"+PALETRA;
  private static final String PREF12= ESPACIO+"(hiper)"+PALETRA;
  private static final String PREF13= ESPACIO+"(hipo)"+PALETRA;
  private static final String PREF14= ESPACIO+"(in)"+PALETRA;
  private static final String PREF15= ESPACIO+"(post|pos)"+PALETRA;
  private static final String PREF16= ESPACIO+"(pre)"+PALETRA;
  private static final String PREF17= ESPACIO+"(re)"+PALETRA;
  private static final String PREF18= ESPACIO+"(sub)"+PALETRA;
  private static final String PREF19= ESPACIO+"(super)"+PALETRA;
  private static final String PREF20= ESPACIO+"(auto)"+PALETRA;
  private static final String PREF21= ESPACIO+"(cuasi)"+PALETRA;
  private static final String PREF22= ESPACIO+"(epi)"+PALETRA;
  private static final String PREF23= ESPACIO+"(ex)"+PALETRA;
  private static final String PREF24= ESPACIO+"(infra)"+PALETRA;
  
 /*-------------------------- Articulos -------------------------*/
  
  //Articulos Def.
  private static final String ART1= ESPACIO+"(el)"+ESPACIO;
  private static final String ART2= ESPACIO+"(la)"+ESPACIO;
  private static final String ART3= ESPACIO+"(lo)"+ESPACIO;
  
  //Articulos Ind.
  private static final String ART4= ESPACIO+"(un)"+ESPACIO;
  private static final String ART5= ESPACIO+"(uno)"+ESPACIO;
  private static final String ART6= ESPACIO+"(una)"+ESPACIO;
  
  /*-------------------------- Preposiciones -------------------------*/
  
  private static final String PREP1= ESPACIO+"(en)"+ESPACIO;
  private static final String PREP2= ESPACIO+"(de)"+ESPACIO;
  private static final String PREP3= ESPACIO+"(desde)"+ESPACIO;
  private static final String PREP4= ESPACIO+"(sin)"+ESPACIO;
  private static final String PREP5= ESPACIO+"(hasta)"+ESPACIO;
  private static final String PREP6= ESPACIO+"(pre)"+ESPACIO;
  private static final String PREP7= ESPACIO+"(para)"+ESPACIO;
  
  /*-------------------------- Conector -------------------------*/
  
  private static final String Y=ESPACIO+"[y]"+ESPACIO;
  
  /*-------------------------- Pronombres -------------------------*/
  
  //Personales
   private static final String PRONOM1= ESPACIO+"yo"+ESPACIO;
   private static final String PRONOM2= ESPACIO+"tu"+ESPACIO;
   private static final String PRONOM3= ESPACIO+"el"+ESPACIO;
   private static final String PRONOM4= ESPACIO+"nosotr+(o|a)"+ESPACIO;
   private static final String PRONOM5= ESPACIO+"vosotr+(o|a)"+ESPACIO;
   private static final String PRONOM6= ESPACIO+"ell+(a|o)"+ESPACIO;
   private static final String PRONOM7= ESPACIO+"me"+ESPACIO;
   private static final String PRONOM8= ESPACIO+"mi"+ESPACIO;
   private static final String PRONOM9= ESPACIO+"conmigo"+ESPACIO;
   private static final String PRONOM10= ESPACIO+"consigo"+ESPACIO;
   private static final String PRONOM11= ESPACIO+"se"+ESPACIO;
   private static final String PRONOM12= ESPACIO+"si"+ESPACIO;
   
   //Demostrativos
   private static final String PRONOM13= ESPACIO+"(est)+(a|e|o)"+ESPACIO;
   private static final String PRONOM14= ESPACIO+"(es)+(a|e|o)"+ESPACIO;
   private static final String PRONOM15= ESPACIO+"(aquel)+(la|lo)"+ESPACIO;
   
   //Posesivos
   private static final String PRONOM16= ESPACIO+"(mi)+(a|o)"+ESPACIO;
   private static final String PRONOM17= ESPACIO+"(tuy)+(a|o)"+ESPACIO;
   private static final String PRONOM18= ESPACIO+"(suy)+(a|o)"+ESPACIO;
   private static final String PRONOM19= ESPACIO+"(nuestr)+(a|o)"+ESPACIO;
   private static final String PRONOM20= ESPACIO+"(vuestr)+(a|o)"+ESPACIO;
   
   //Indefinidos
   private static final String PRONOM21= ESPACIO+"algun+(a|o)"+ESPACIO;
  private static final String PRONOM22= ESPACIO+"alguien"+ESPACIO;
  private static final String PRONOM23= ESPACIO+"nadie"+ESPACIO;
   private static final String PRONOM24= ESPACIO+"nada"+ESPACIO;
   private static final String PRONOM25= ESPACIO+"algo"+ESPACIO;
   private static final String PRONOM26= ESPACIO+"otr+(a|o)"+ESPACIO;
   private static final String PRONOM27= ESPACIO+"vari+(a|o)"+ESPACIO;
   private static final String PRONOM28= ESPACIO+"much+(a|o)"+ESPACIO;
   private static final String PRONOM29= ESPACIO+"poc+(a|o)"+ESPACIO;
   
   //Numerales
   private static final String PRONOM30= ESPACIO+"dos"+ESPACIO;
   private static final String PRONOM31= ESPACIO+"tres"+ESPACIO;
   private static final String PRONOM32= ESPACIO+"cuatro"+ESPACIO;
   private static final String PRONOM33= ESPACIO+"tercer+(a|o)"+ESPACIO;
   private static final String PRONOM34= ESPACIO+"segund+(a|o)"+ESPACIO;
   private static final String PRONOM35= ESPACIO+"primer+(a|o)"+ESPACIO;
   
   //Reflexivos
   private static final String PRONOM36= ESPACIO+"te"+ESPACIO;
   private static final String PRONOM37= ESPACIO+"me"+ESPACIO;
   
   /*-------------------------- Adejtivos -------------------------*/
   
     private static final String ADJ1= PALETRA+"ient(a|o)"+ESPACIO;
     private static final String ADJ2= PALETRA+"il"+ESPACIO;
    private static final String ADJ3= PALETRA+"ad(a|o)"+ESPACIO;
    private static final String ADJ4= PALETRA+"id(a|o)"+ESPACIO;
     private static final String ADJ5= PALETRA+"in(a|o)"+ESPACIO;
     private static final String ADJ6= PALETRA+"iz(o|a)"+ESPACIO;
     private static final String ADJ7= PALETRA+"ar"+ESPACIO;
     private static final String ADJ8= PALETRA+"ens(a|e)"+ESPACIO;
     private static final String ADJ9= PALETRA+"os(a|o)"+ESPACIO;
     private static final String ADJ10= PALETRA+"ud(a|o)"+ESPACIO;
     private static final String ADJ11= PALETRA+"eñ(a|o)"+ESPACIO;
     private static final String ADJ12= PALETRA+"an(a|o)"+ESPACIO;
     private static final String ADJ13= PALETRA+"al"+ESPACIO;
   
  
/*-------------------------- Sufijos de Sustantivos -------------------------*/
   
    
    private static final String SUFSU1= PALETRA+"(a|e|ie)nte"+ESPACIO;
    private static final String SUFSU2= PALETRA+"a(l|r)"+ESPACIO;
   private static final String SUFSU3= PALETRA+"eria"+ESPACIO;
    private static final String SUFSU4= PALETRA+"(e|a)ncia"+ESPACIO;
    private static final String SUFSU5= PALETRA+"er(a|o)"+ESPACIO;
    private static final String SUFSU6= PALETRA+"ez"+ESPACIO;
    private static final String SUFSU7= PALETRA+"ura"+ESPACIO;
   private static final String SUFSU8= PALETRA+"emo"+ESPACIO;
    private static final String SUFSU9= PALETRA+"cion"+ESPACIO;
    private static final String SUFSU10= PALETRA+"do(r|ra)"+ESPACIO;
    
   
 /*-------------------------- Sufijos Aumentativos (Sustantivos) -------------------------*/
    private static final String AUMEN1= PALETRA+"azo"+ESPACIO;
    private static final String AUMEN2= PALETRA+"o(n|a)"+ESPACIO;
    private static final String AUMEN3= PALETRA+"ot(e|a)"+ESPACIO;
  
 /*-------------------------- Sufijos Diminutivos (Sustantivos) -------------------------*/
    ;
    private static final String DIMI1= PALETRA+"ic(a|o)"+ESPACIO;
    private static final String DIMI2= PALETRA+"uelo(a|o)"+ESPACIO;
    private static final String DIMI3= PALETRA+"it(a|o)"+ESPACIO;
    private static final String DIMI4= PALETRA+"ill(a|o)"+ESPACIO;
    private static final String DIMI5= PALETRA+"i(n|na)"+ESPACIO;
    private static final String DIMI6= PALETRA+"cit(o|a)"+ESPACIO;

/*-------------------------- Sufijos Despectivos (Sustantivos) -------------------------*/
     
     
     private static final String DESP1= PALETRA+"uch(a|o)"+ESPACIO;
     private static final String DESP2= PALETRA+"ac(a|o)"+ESPACIO;
     private static final String DESP3= PALETRA+"ach(a|o)"+ESPACIO;
    private static final String DESP4= PALETRA+"ang(o|a)"+ESPACIO;
     private static final String DESP5= PALETRA+"at(o|a)"+ESPACIO;
     private static final String DESP6= PALETRA+"aj(a|o)"+ESPACIO;
     private static final String DESP7= PALETRA+"astr(a|o)"+ESPACIO;
     

    
//eliminar s
  private static final String ELIMINARS= "[s]\\b";
  
//Metodos para eliminar Regex.
  
  public String ElimPuntuacion(String Texto)
  {
      Pattern sigpunt=Pattern.compile(SIGNOS);
      Matcher coincidencia=sigpunt.matcher(Texto);
      
      Texto= coincidencia.replaceAll("");
      
      /*sigpunt= Pattern.compile(COMILLAS);
        coincidencia=sigpunt.matcher(Texto);
        
        Texto=coincidencia.replaceAll("");*/
      
      return Texto;
  }
  
  public String ElimDigit(String Texto)
  {
      Pattern digit=Pattern.compile(NUMEROS);
      Matcher coincidencia=digit.matcher(Texto);
      
      Texto=coincidencia.replaceAll("");
      
      return Texto;
      
  }
  
  public String EliminarS(String Texto)
  {
      Pattern elims=Pattern.compile(ELIMINARS);
      
      Matcher coincidencia=elims.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      return Texto;
  }
  
  public String ElimTildes(String Texto)
  {
        Matcher coincidencia;
        Pattern elimtilde;
        
        elimtilde = Pattern.compile(TILDEA);
        coincidencia=elimtilde.matcher(Texto);
        Texto=coincidencia.replaceAll(CAMBIOA);
                
        elimtilde=Pattern.compile(TILDEE);
        coincidencia=elimtilde.matcher(Texto);
        Texto=coincidencia.replaceAll(CAMBIOE);
        
        elimtilde=Pattern.compile(TILDEI);
        coincidencia=elimtilde.matcher(Texto);
        Texto=coincidencia.replaceAll(CAMBIOI);
        
        elimtilde=Pattern.compile(TILDEO);
        coincidencia=elimtilde.matcher(Texto);
        Texto=coincidencia.replaceAll(CAMBIOO);
        
        elimtilde=Pattern.compile(TILDEU);
        coincidencia=elimtilde.matcher(Texto);
        Texto=coincidencia.replaceAll(CAMBIOU);
        
      
      return Texto;
  }  
  
  public String ElimPrefijos(String Texto)
  {
      Pattern epref;
      Matcher coincidencia;
      
      epref=Pattern.compile(PREF1);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF2);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF3);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF4);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF5);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF6);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF7);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF8);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF9);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF10);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF11);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF12);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF13);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF14);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF15);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF16);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF17);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF18);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF19);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       epref=Pattern.compile(PREF20);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epref=Pattern.compile(PREF21);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epref=Pattern.compile(PREF22);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epref=Pattern.compile(PREF23);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epref=Pattern.compile(PREF24);
      coincidencia=epref.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      return Texto;
      
  }
  
  
  public String ElimArticulos(String Texto)
  {
      Pattern eart;
      Matcher coincidencia;
      
      eart=Pattern.compile(ART1);
      coincidencia=eart.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      eart=Pattern.compile(ART2);
      coincidencia=eart.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      eart=Pattern.compile(ART3);
      coincidencia=eart.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      eart=Pattern.compile(ART4);
      coincidencia=eart.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      eart=Pattern.compile(ART5);
      coincidencia=eart.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      eart=Pattern.compile(ART6);
      coincidencia=eart.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      return Texto;
  }
  public String ElimConector (String Texto)
  {
      Pattern econ;
      Matcher coincidencia;
      
      econ=Pattern.compile(Y);
      coincidencia=econ.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      return Texto;
  }
  
  public String ElimPreposiciones (String Texto)
  {
      Pattern eprep;
      Matcher coincidencia;
      
      eprep=Pattern.compile(PREP1);
      coincidencia=eprep.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      eprep=Pattern.compile(PREP2);
      coincidencia=eprep.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      eprep=Pattern.compile(PREP3);
      coincidencia=eprep.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      eprep=Pattern.compile(PREP4);
      coincidencia=eprep.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      eprep=Pattern.compile(PREP5);
      coincidencia=eprep.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      eprep=Pattern.compile(PREP6);
      coincidencia=eprep.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      eprep=Pattern.compile(PREP7);
      coincidencia=eprep.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      return Texto;
  }
  
  public String ElimPronombres(String Texto)
  {
      Pattern epron;
      Matcher coincidencia;
      
      epron= Pattern.compile(PRONOM1);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM2);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM3);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM4);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM5);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM6);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM7);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM8);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM9);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM10);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM11);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM12);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM13);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM14);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      
      epron= Pattern.compile(PRONOM15);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM16);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM17);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM18);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM19);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM20);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM21);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM22);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM23);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM24);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM25);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM26);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM27);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM28);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM29);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM30);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM31);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM32);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM33);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM34);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM35);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM36);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      epron= Pattern.compile(PRONOM37);
      coincidencia=epron.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      return Texto;
  }
  
    public String ElimSufijos(String Texto)
  {
      Pattern esuf;
      Matcher coincidencia;
      
      /*-----Sufijos de Sustantivos-----*/
      
      esuf= Pattern.compile(SUFSU1);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       esuf= Pattern.compile(SUFSU2);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(SUFSU3);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       esuf= Pattern.compile(SUFSU4);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(SUFSU5);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       esuf= Pattern.compile(SUFSU6);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       esuf= Pattern.compile(SUFSU7);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       esuf= Pattern.compile(SUFSU8);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       esuf= Pattern.compile(SUFSU9);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       esuf= Pattern.compile(SUFSU10);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      /*-----Aumentativos-----*/
      
      esuf= Pattern.compile(AUMEN1);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(AUMEN2);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(AUMEN3);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      /*-----Diminutivos-----*/
      
      esuf= Pattern.compile(DIMI1);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(DIMI2);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(DIMI3);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(DIMI4);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
       esuf= Pattern.compile(DIMI5);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(DIMI6);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      /*-----Despectivo-----*/
      
      esuf= Pattern.compile(DESP1);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(DESP2);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(DESP3);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(DESP4);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(DESP5);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(DESP6);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(DESP7);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      /*-----Adjetivo-----*/
      
      esuf= Pattern.compile(ADJ1);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(ADJ2);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(ADJ3);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(ADJ4);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(ADJ5);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(ADJ6);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(ADJ7);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(ADJ8);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(ADJ9);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(ADJ10);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(ADJ11);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(ADJ12);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile(ADJ13);
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      //-----Extras-----
      
      esuf= Pattern.compile("por");
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      esuf= Pattern.compile("su");
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
     esuf= Pattern.compile("que");
      coincidencia=esuf.matcher(Texto);
      Texto=coincidencia.replaceAll("");
      
      return Texto;
      
  }
    public static String[] separarFrase(String cadena) {
        int cantp = 0;                                 // Cantidad de palabras
         
        //buscamos espacios en blanco
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ' ') {
                cantp++;                               // Aumentamos en uno la cantidad de palabras
            }
        }
         
        
        String[] partes = new String[cantp + 1];
        for (int i = 0; i < partes.length; i++) {
            partes[i] = "";
        }
         
        int ind = 0;                                    //índice
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ' ') {
                ind++;                                  //Pasamos a la siguiente palabra
                continue;                               // i siguiente
            }
            partes[ind] += cadena.charAt(i);            //agregar caracter a la palabra
        }
        return partes;                                  // Devolvemos las partes
    }

  public static <K, V extends Comparable<V>> Map<K, V> 
    sortByValues(final Map<K, V> map) {
    Comparator<K> valueComparator = 
             new Comparator<K>() {
      public int compare(K k1, K k2) {
        int compare = 
              map.get(k1).compareTo(map.get(k2));
        if (compare == 0) 
          return 1;
        else 
          return compare;
      }
    };
 
    Map<K, V> sortedByValues = 
      new TreeMap<K, V>(valueComparator);
    sortedByValues.putAll(map);
    return sortedByValues;
  } 
    
  public static void main(String[] args)throws FileNotFoundException
  {
      
      Map<String, Integer> unique = new TreeMap<>();

      //---------------------------------------------------------------------------------------------------------
      archivos a = new archivos();
      String testo = a.leerTXT("C:\\Users\\Nicolas\\Desktop\\Algo_Porter\\archivo\\eltexto.txt"); //Verificar direccion del Archivo .TXT antes de probar el codigo. 
                testo = testo.toLowerCase();
      //---------------------------------------------------------------------------------------------------------
      
      Regex regex = new Regex();
      
      testo=regex.EliminarS(testo);
      testo=regex.ElimPuntuacion(testo);
      testo=regex.ElimTildes(testo);
      testo=regex.ElimDigit(testo);
      testo=regex.ElimArticulos(testo);
      testo=regex.ElimPreposiciones(testo);
      testo=regex.ElimConector(testo);
      testo=regex.ElimPrefijos(testo);
      testo=regex.ElimPronombres(testo);
      testo=regex.ElimSufijos(testo);
      
      String[] p = separarFrase(testo);
      
      int i,j;
      
      for (i=0; i<p.length; i++) 
     { 
        String texto=p[i]; 
        if(!"".equals(p[i]))
        {
            unique.put(texto,(unique.get(texto) == null?1:(unique.get(texto)+1)));
        } 
      } 
   Map sortedMap = sortByValues(unique);
 
   String txt = sortedMap.toString();
   txt=regex.EliminarS(txt);
   txt=regex.ElimPuntuacion(txt);
   txt=regex.ElimTildes(txt);
   txt=regex.ElimArticulos(txt);
   txt=regex.ElimPreposiciones(txt);
   txt=regex.ElimConector(txt);
   txt=regex.ElimPrefijos(txt);
   txt=regex.ElimPronombres(txt);
   txt=regex.ElimSufijos(txt);
   String[] Separado = separarFrase(txt);
   
   for (i=Separado.length-1; i>Separado.length-11; i--){
       System.out.println(Separado[i]);
   }
  }  
}
 

