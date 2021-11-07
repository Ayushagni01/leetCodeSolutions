package com.examServer.ExamServer.Controller;

import com.examServer.ExamServer.model.exam.Category;
import com.examServer.ExamServer.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    //step1 add category  //category Service autowired
    //step2 postMapping


    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category)
    {
        Category category1 = this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }

    //step 3 get category

    //single category
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId)
    {
        return  this.categoryService.getCategory(categoryId);
    }

    //getting all category
    @GetMapping("/")
    public ResponseEntity<?> getCategories()
    {
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    //step 4 update

    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category)
    {
        return this.categoryService.updateCategory(category);

    }

    //step 5 delete

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        this.categoryService.deleteCategory(categoryId);
    }


}


//step 1 restCOntroller and RequestBody Define
