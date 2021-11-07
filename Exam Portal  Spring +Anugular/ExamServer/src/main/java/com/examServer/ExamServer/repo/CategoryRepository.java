package com.examServer.ExamServer.repo;

import com.examServer.ExamServer.model.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {


}
//step 1 created Model
//step 2 created Repository here  category,quiz,question repository
//Step 3 Created Services for aboce rep and model
//step 4 using Category Service and define its method
//step5 Create Category Service Impl anf implement Category Service in this class and override its method
                //autowire repository firt CategoryRepo
//step 6 implemented CategoryServicempl Methods
//step7 using Quiz Services defining the declaring method there
//step 8 cerate QuizImpl for implementing Quiz Section details
            //autowire quiz repos for implementing methods
//step 9 implementing quizServiceImpl and its Method
            //autowire quizServiceImpl for implementing method
//step 10 mplements questionServiceImpl
//step11 creating category,quiz,question Controller in controller folders

//Step of CategoryController will update the details --check Category Controller for further informations

//ste[ 12- Implementing QuizController
