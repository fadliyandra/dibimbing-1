package dibimbing.team2.utils;

//import com.dibimbing.assignment3.model.Karyawan;
//import com.dibimbing.assignment3.model.KaryawanMybatis;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TemplateResponse {
    public Map templateSukses(Object objek){
        Map map = new HashMap();
        map.put("data", objek);
        map.put("message", "sukses");
        map.put("status", "200");
        return map;
    }

    public Map templateSukses(Object objek,String message, String status){
        Map map = new HashMap();
        map.put("data", objek);
        map.put("message", message);
        map.put("status",status);
        return map;
    }

    public Map templateEror(Object objek){
        Map map = new HashMap();
        map.put("message", objek);
        map.put("status", "404");
        return map;
    }
    public Map notFound(Object objek){
        Map map = new HashMap();
        map.put("message", objek);
        map.put("status", "404");
        return map;
    }


    public boolean chekNull(Object obj){
        return obj == null;
    }

//    public List<Karyawan> conversiToKaryawan(List<KaryawanMybatis> list) {
//        List<Karyawan> listKaryawan=  new ArrayList<>();
//        for(KaryawanMybatis obj : list){
//
//            Karyawan objKaryawan = new Karyawan();
//
//            objKaryawan.setId(obj.getResid());
//            objKaryawan.setNama(obj.getResnama());
//            objKaryawan.setJk(obj.getResjk());
//            objKaryawan.setDob(obj.getResdob());
//            objKaryawan.setAlamat(obj.getResalamat());
//            objKaryawan.setStatus(obj.getResstatus());
//            objKaryawan.setNik(obj.getResnik());
//            objKaryawan.setNpwp(obj.getResnpwp());
//            objKaryawan.setCreated_date(obj.getCreated_date());
//            objKaryawan.setUpdated_date(obj.getUpdated_date());
//            objKaryawan.setDeleted_date(obj.getDeleted_date());
//            listKaryawan.add(objKaryawan);
//        }
//        return listKaryawan;
//    }

//    public Karyawan conversiToKaryawan(KaryawanMybatis obj) {
//
//            Karyawan objKaryawan = new Karyawan();
//
//            objKaryawan.setId(obj.getResid());
//            objKaryawan.setNama(obj.getResnama());
//            objKaryawan.setJk(obj.getResjk());
//            objKaryawan.setDob(obj.getResdob());
//            objKaryawan.setAlamat(obj.getResalamat());
//            objKaryawan.setStatus(obj.getResstatus());
//            objKaryawan.setNik(obj.getResnik());
//            objKaryawan.setNpwp(obj.getResnpwp());
//            objKaryawan.setCreated_date(obj.getCreated_date());
//            objKaryawan.setUpdated_date(obj.getUpdated_date());
//            objKaryawan.setDeleted_date(obj.getDeleted_date());
//
//        return objKaryawan;
//    }
}
