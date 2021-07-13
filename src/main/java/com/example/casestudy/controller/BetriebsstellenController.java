package com.example.casestudy.controller;

import com.example.casestudy.entity.Betriebsstelle;
import com.example.casestudy.entity.Betriebsstellen;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BetriebsstellenController {

    Betriebsstellen betriebsstellen = Betriebsstellen.getInstance();

    @GetMapping("/betriebsstelle/{abk}")
    public Betriebsstelle getBetriebsstelle(@PathVariable String abk){
        Betriebsstelle betriebsstelle = betriebsstellen.getBetriebsstelle(abk);
        if (betriebsstelle != null){
            return betriebsstelle;
        } else{
            throw new BetriebsstelleNotFoundException(abk);
        }
    }


}
