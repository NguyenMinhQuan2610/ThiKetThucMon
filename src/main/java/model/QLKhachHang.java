package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import util.FileHelper;

/**
 *
 * Họ tên sinh viên: 
 */
public class QLKhachHang {

    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

   
    public void DocKhachHang(String filename) {
        //sinh viên viết code 
        ArrayList<String> data = FileHelper.readFileText(filename); //doc file
        dsKhachHang.clear();
        for (String item : data) {
            String[] arr = item.split(";");
            KhachHang kh = new KhachHang();
            kh.setMaso(arr[0]);
            kh.setHoten(arr[1]);
            kh.setSonhankhau(Integer.parseInt(arr[2]));
            kh.setChisocu(Double.parseDouble(arr[3]));
            kh.setChisomoi(Double.parseDouble(arr[4]));
            dsKhachHang.add(kh);
        }

    }

    public boolean GhiHoaDon(String filename) {
        //sinh viên viết code 
         ArrayList<String> output = new ArrayList<>();
        for (KhachHang kh : dsKhachHang) {
            String info = kh.getMaso()+ ";" + kh.getHoten()+ ";" + kh.getSonhankhau()+ ";" + kh.getChisocu()+ ";" + kh.getChisomoi();
            output.add(info);
        }
        return FileHelper.writeFileText(filename, output);
        
    }

   
    public void sapXepTheoMucTieuThu() {
        //sinh viên viết code
        Comparator<KhachHang> cmp = (kh1, kh2) -> {
            return Double.compare(kh1.getTieuThu(), kh2.getTieuThu());
        };
        Collections.sort(dsKhachHang, cmp);
    }
    
    public double getTieuThuCaoNhat()
    {
      double max=dsKhachHang.get(0).getTieuThu();
      for(KhachHang kh:dsKhachHang){
          if(kh.getTieuThu()>max){
              max=kh.getTieuThu();
          }
      }
      return max;
    }
    
    public double getTieuThuThapNhat()
    {
       double min=0;
       return min;       
    }
    
    public double getTieuThuTrungBinh()
    {
        double Tong=0;
        for(KhachHang kh:dsKhachHang){
            Tong+=kh.getTieuThu();
        }
       return Tong/ dsKhachHang.size();     
    }
}
