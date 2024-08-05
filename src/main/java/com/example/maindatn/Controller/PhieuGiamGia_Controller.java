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

import java.util.*;

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
        Page<PhieuGiamGia_Entity> pageData = pggRepo.getPhieuGG(PageRequest.of(page, 1)); // Thay đổi để lấy theo trang
        model.addAttribute("dataList",pageData.getContent());
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
//    @GetMapping("table1")
//    @ResponseBody
//    public Map<String, Object> originTable(@RequestParam("page") int page, @RequestParam("length") int length) {
//        Page<PhieuGiamGia_Entity> pageData = pggRepo.getPhieuGG(PageRequest.of(page, length));
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("data", pageData.getContent());
//        response.put("recordsTotal", pageData.getTotalElements());
//        response.put("recordsFiltered", pageData.getTotalElements());
//        return response;
//    }

    @GetMapping("search")
    @ResponseBody
    public List<PhieuGiamGia_Entity> searchTable(@RequestParam("query") String query) {
        // Xử lý tìm kiếm dữ liệu dựa trên query
        List<PhieuGiamGia_Entity> searchData = pggRepo.ListtimTheoTen(query);
      // Hàm searchData là để giả lập việc tìm kiếm
        return searchData;
    }

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
        System.out.println(phieuGiamGiaEntity.getGiamToiDa());
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
