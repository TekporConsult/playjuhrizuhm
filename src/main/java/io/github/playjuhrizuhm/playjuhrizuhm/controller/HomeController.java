package io.github.playjuhrizuhm.playjuhrizuhm.controller;
import io.github.playjuhrizuhm.playjuhrizuhm.component.Methods;
import io.github.playjuhrizuhm.playjuhrizuhm.component.PlayComponent;
import io.github.playjuhrizuhm.playjuhrizuhm.component.Result;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v-1.0/")
public class HomeController {

    @PostMapping("/content")
    public Iterable testPlay(@RequestBody String paths) throws InterruptedException {
        ArrayList<Result> arrayList = new ArrayList<>();

        if(paths.length()>20){
            double percentage = 0;
            final String solution = Methods.solution(paths);
            if(!solution.isEmpty()){
                final PlayComponent serializable = Methods.serializable(solution);
                percentage = Methods.findSimilarity(serializable.getPlayContent(), paths);
                if(percentage > 0.25){
                    arrayList.add(new Result(serializable.getPlayContent(),serializable.getSource(),percentage));
                }
            }
        }
       return arrayList;
    }



}

