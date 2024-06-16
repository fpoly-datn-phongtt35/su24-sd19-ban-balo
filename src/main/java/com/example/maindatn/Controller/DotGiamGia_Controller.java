package com.example.maindatn.Controller;

import com.example.maindatn.Entity.DotGiamGia_Entity;
import com.example.maindatn.Entity.PhieuGiamGia_Entity;
import com.example.maindatn.Entity.User_Entity;
import com.example.maindatn.Model.FormDgg;
import com.example.maindatn.Model.FormPgg;
import com.example.maindatn.Repository.DotGiamGia_Repository;
import com.example.maindatn.Repository.PhieuGiamGia_Repository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("dgg")
public class DotGiamGia_Controller {
    @Autowired
    private DotGiamGia_Repository dggRepo;

    DotGiamGia_Controller() {
    }


    @GetMapping("index")
    private String getAll(Model model, @RequestParam("page") Optional<Integer> pageP){
        int page = pageP.orElse(0);
        Pageable pageable = PageRequest.of(page,1);
        model.addAttribute("page",dggRepo.getDotGG(pageable));
        return "dgg/index";
    }


    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("data", new FormDgg());
        return "dgg/create";
    }

    @PostMapping("store")
    public String createDone(@Valid @ModelAttribute("data") FormDgg formDgg, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Co loi nhe");
            System.out.printf(formDgg.toString());
            return "dgg/create";
        }

        User_Entity user = new User_Entity();
//        user.setId(formDgg.getNguoiTao());
        User_Entity user1 = new User_Entity();

        DotGiamGia_Entity dotGiamGiaEntity = new DotGiamGia_Entity(
                formDgg.getId(),
                formDgg.getMa(),
                formDgg.getTen(),
                formDgg.getGiaTriDotGiamGia(),
                formDgg.getBeginday(),
                formDgg.getEndday(),
                formDgg.getGiamToiDa(),
                formDgg.getDieuKien(),
                user,
                user1,
                formDgg.getNgayTao(),
                formDgg.getNgaySua(),
                formDgg.getTrangthai()
        );
        this.dggRepo.save(dotGiamGiaEntity);
        return "redirect:/dgg/index";
    }

    @GetMapping("edit/{id}")
    public String Edit(@PathVariable("id") DotGiamGia_Entity dotGiamGiaEntity, Model model) {
        model.addAttribute("data", dotGiamGiaEntity);
        return "dgg/edit";
    }

    @PostMapping("update/{id}")
    public String EditDone(@PathVariable("id") DotGiamGia_Entity dotGiamGiaEntity,
                           @Valid @ModelAttribute("data") FormDgg formDgg, BindingResult result) {
        if (result.hasErrors()) {
            System.out.printf("k on r");
            return "dgg/edit";
        }
        User_Entity user = new User_Entity();
        user.setIdUsers(formDgg.getNguoiTao());

        User_Entity user1 = new User_Entity();
        user1.setIdUsers(formDgg.getNguoiSua());

        dotGiamGiaEntity.setMa(formDgg.getMa());
        dotGiamGiaEntity.setTen(formDgg.getTen());

        dotGiamGiaEntity.setBeginday(formDgg.getBeginday());
        dotGiamGiaEntity.setEndday(formDgg.getEndday());

        dotGiamGiaEntity.setGiamToiDa(formDgg.getGiamToiDa());
        dotGiamGiaEntity.setDieuKien(formDgg.getDieuKien());
        dotGiamGiaEntity.setNgayTao(formDgg.getNgayTao());
        dotGiamGiaEntity.setNgaySua(formDgg.getNgaySua());
        dotGiamGiaEntity.setNguoiSua(user1);
        dotGiamGiaEntity.setNguoiTao(user);

        dotGiamGiaEntity.setTrangthai(formDgg.getTrangthai());

        this.dggRepo.save(dotGiamGiaEntity);

        return "redirect:/dgg/index";
    }


    @GetMapping("delete/{id}")
    public String deleteDone(@PathVariable("id") int id) {

        this.dggRepo.deleteById(id);
        return "redirect:/dgg/index";
    }

}
