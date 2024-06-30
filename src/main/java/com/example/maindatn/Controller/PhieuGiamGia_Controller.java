package com.example.maindatn.Controller;


import com.example.maindatn.Entity.PhieuGiamGia_Entity;
import com.example.maindatn.Entity.User_Entity;
import com.example.maindatn.Model.FormPgg;
import com.example.maindatn.Repository.PhieuGiamGia_Repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("pgg")
public class PhieuGiamGia_Controller {
    @Autowired
    private PhieuGiamGia_Repository pggRepo;

    PhieuGiamGia_Controller() {
    }

    @GetMapping("index")
    private String getHTMLtable(Model model,@RequestParam("page") Optional<Integer> pageP
    ){
        int page = pageP.orElse(0);
        model.addAttribute("dataList",pggRepo.getPhieuGG());
        return "pgg/index";
    }

    @GetMapping("table1")
    @ResponseBody
    public List<PhieuGiamGia_Entity> originTable() {
        // Xử lý tìm kiếm dữ liệu dựa trên query
        List<PhieuGiamGia_Entity> searchData = pggRepo.getPhieuGG();
        // Hàm searchData là để giả lập việc tìm kiếm
        return searchData;
    }

    @GetMapping("search")
    @ResponseBody
    public List<PhieuGiamGia_Entity> searchTable(@RequestParam("query") String query) {
        // Xử lý tìm kiếm dữ liệu dựa trên query
        List<PhieuGiamGia_Entity> searchData = pggRepo.ListtimTheoTen(query);
      // Hàm searchData là để giả lập việc tìm kiếm
        return searchData;
    }

//    private List<PhieuGiamGia_Entity> searchData(String query) {
//        // Giả lập hàm tìm kiếm dữ liệu
//        List<PhieuGiamGia_Entity> result = new ArrayList<>();
//        for (PhieuGiamGia_Entity data : pggRepo.getPhieuGG()) {
//            // Kiểm tra xem dữ liệu có chứa query không (tùy vào yêu cầu của bạn)
//            if (data.getTen().toLowerCase().contains(query.toLowerCase()) ||
//                    data.getMa().toLowerCase().contains(query.toLowerCase())) {
//                result.add(data);
//            }
//        }
//        return result;
//    }

//
//
//
//    @GetMapping("index/getByName")
//    private String getByTen(Model model,@RequestParam("page") Optional<Integer> pageP,
////                            @RequestParam("ten") String ten,//
//                            @RequestParam("query") String query
//                           ){
//        int page = pageP.orElse(0);
//        Pageable pageable = PageRequest.of(page,1);
//        model.addAttribute("page",pggRepo.PagetimTheoTen(pageable,query));
//        return  "data_table";
//    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("lstNT", pggRepo.getme());
        model.addAttribute("data", new FormPgg());
        return "pgg/create";
    }

    @PostMapping("store")
    public String createDone(@Valid @ModelAttribute("data") FormPgg formPgg, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Co loi nhe");
            System.out.printf(formPgg.toString());
            return "pgg/create";
        }

        User_Entity user = new User_Entity();
        user.setIdUsers(formPgg.getNguoiTao());
        User_Entity user1 = new User_Entity();
        user1.setIdUsers(formPgg.getNguoiSua());

        PhieuGiamGia_Entity phieuGiamGiaEntity = new PhieuGiamGia_Entity(
                formPgg.getId(),
                formPgg.getMa(),
                formPgg.getTen(),

                formPgg.getBeginday(),
                formPgg.getEndday(),

                formPgg.getGiamToiDa(),
                user,
                user1,
                formPgg.getNgayTao(),
                formPgg.getNgaySua(),
                formPgg.getTrangthai()
        );
        this.pggRepo.save(phieuGiamGiaEntity);
        return "redirect:/pgg/index";
    }

    @GetMapping("edit/{id}")
    public String Edit(@PathVariable("id") PhieuGiamGia_Entity phieuGiamGiaEntity, Model model) {
        model.addAttribute("lstNT", pggRepo.getme());

        model.addAttribute("data", phieuGiamGiaEntity);
        return "pgg/edit";
    }

    @PostMapping("update/{id}")
    public String EditDone(@PathVariable("id") PhieuGiamGia_Entity phieuGiamGiaEntity,
                           @Valid @ModelAttribute("data") FormPgg formPgg, BindingResult result) {
        if (result.hasErrors()) {
            System.out.printf("k on r");
            return "pgg/edit";
        }
        User_Entity user = new User_Entity();
        user.setIdUsers(formPgg.getNguoiTao());

        User_Entity user1 = new User_Entity();
        user1.setIdUsers(formPgg.getNguoiSua());

        phieuGiamGiaEntity.setMa(formPgg.getMa());
        phieuGiamGiaEntity.setTen(formPgg.getTen());

        phieuGiamGiaEntity.setBeginday(formPgg.getBeginday());
        phieuGiamGiaEntity.setEndday(formPgg.getEndday());

        phieuGiamGiaEntity.setGiamToiDa(formPgg.getGiamToiDa());

        phieuGiamGiaEntity.setNgayTao(formPgg.getNgayTao());
        phieuGiamGiaEntity.setNgaySua(formPgg.getNgaySua());
        phieuGiamGiaEntity.setNguoiSua(user1);
        phieuGiamGiaEntity.setNguoiTao(user);

        phieuGiamGiaEntity.setTrangthai(formPgg.getTrangthai());

        this.pggRepo.save(phieuGiamGiaEntity);

        return "redirect:/pgg/index";
    }

    @GetMapping("delete/{id}")
    public String deleteDone(@PathVariable("id") int id) {
        this.pggRepo.updateTrangthai_0(id);
        return "redirect:/pgg/index";
    }


}
