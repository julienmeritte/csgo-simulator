package com.csgosimulator.backend.controllers;


import com.csgosimulator.backend.Utils.Utils;
import com.csgosimulator.backend.models.Player;
import com.csgosimulator.backend.services.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllPlayers() {

        List<Player> players = playerService.getAllPlayer();

        return ResponseEntity.status(200).body(players);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addPlayer(@RequestParam(name = "firstname") String firstname, @RequestParam(name = "lastname") String lastname, @RequestParam(name = "nickname") String nickname) throws Exception {

        if (firstname == null || lastname == null || nickname == null) {
            throw new Exception(); // TODO
        }

        Player player = playerService.createPlayer(firstname, lastname, nickname);

        return ResponseEntity.status(200).body(player);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> handleMissingParams(MissingServletRequestParameterException exception) throws JSONException {

        JSONObject response = new JSONObject();
        response.put("message", "Params incorrects");
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(Utils.jsonifyParamsMissing(exception));
        response.put("data", jsonArray);

        return ResponseEntity.status(400).body(response.toString());
    }
}
