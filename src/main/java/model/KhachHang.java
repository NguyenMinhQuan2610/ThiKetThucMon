package model;

/**
 *
 * Họ tên sinh viên: 
 */
public class KhachHang {
    private String maso;
    private String hoten;
    private int sonhankhau;
    private double chisocu;
    private double chisomoi;            

    //constructor
    public KhachHang() {
    }

    public KhachHang(String maso) {
        this.maso = maso;
    }

    public KhachHang(String maso, String hoten, int sonhankhau, double chisocu, double chisomoi) {
        this.maso = maso;
        this.hoten = hoten;
        this.sonhankhau = sonhankhau;
        this.chisocu = chisocu;
        this.chisomoi = chisomoi;
    }

    //setter và getter

    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getSonhankhau() {
        return sonhankhau;
    }

    public void setSonhankhau(int sonhankhau) {
        this.sonhankhau = sonhankhau;
    }

    public double getChisocu() {
        return chisocu;
    }

    public void setChisocu(double chisocu) {
        this.chisocu = chisocu;
    }

    public double getChisomoi() {
        return chisomoi;
    }

    public void setChisomoi(double chisomoi) {
        this.chisomoi = chisomoi;
    }

     
    
    //phương thức tính toán    

    public double getTieuThu()
    {
      return chisomoi-chisocu;
    }
    
    public double getDinhMuc()
    {
       return sonhankhau*4;
    }
    
    
    public double tinhTienTra()
    {
       double DinhMuc=getDinhMuc();
       double TieuThu=getTieuThu();
       double Giaban=0;
       
       if(TieuThu>DinhMuc)
           Giaban=TieuThu*6700;
       else if(TieuThu<=DinhMuc*1.5)
           Giaban=DinhMuc*6700+(TieuThu-DinhMuc)*12900;
       else
           Giaban=DinhMuc*6700+DinhMuc*0.5*12900+((TieuThu-DinhMuc)*1.5*14400);
       return Giaban + 0.05*Giaban+0.25*Giaban+0.08*(0.25*Giaban);
    }         
}
