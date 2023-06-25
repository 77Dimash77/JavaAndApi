import java.util.ArrayList;
import java.util.List;

public class Hbooks {
   
    private String name;
    private Integer pamiat;
    private String nakopitel;   
    private boolean vstroenWind;
    private float chistProcec;
    List<String> polopisanie = new ArrayList<>();

    public Hbooks(String name, Integer pamiat, String nakopitel, boolean vstroenWind, float chistProcec){
      this.name = name;
      this.pamiat = pamiat;
      this.nakopitel = nakopitel;
      this.vstroenWind = vstroenWind;
      this.chistProcec = chistProcec;
    }

        public void Prodano(int n) {
        System.out.println(this.name + " продано " + n + " раз");
    }
    public void Wind() {
        if (vstroenWind) {
            System.out.println(this.name + "Windows 11 не установлен");
        }
        else {
            vstroenWind = true;
            System.out.println("Windows 11 же установлен" + this.name);
        }
    }
    public void VvodOpisania(String opisanie) {
        this.polopisanie.add(opisanie);
        System.out.println(this.polopisanie);
    } 
    public void PokazOpisania() {
        System.out.println(this.polopisanie);
}
@Override
public String toString(){
  return "Наименование: " + name + "/ " + "Память: " + pamiat + "/ " + "Накопитель: " + nakopitel + "/ " + "Windows вcтройка: " + vstroenWind + "/ " + "Чистота процессора: " + chistProcec;
}

public String getName(){
  return name;
}
public Integer getPamiat(){
  return pamiat;
}
public String getNakopitel(){
  return nakopitel;
}
public boolean getWin(){
  return vstroenWind;
}
public float getProc(){
  return chistProcec;
}
}
