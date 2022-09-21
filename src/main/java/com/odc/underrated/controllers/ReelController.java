package com.odc.underrated.controllers;

import com.odc.underrated.models.Reel;
import com.odc.underrated.services.ReelService;
import com.odc.underrated.util.ServiceError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/r")
public class ReelController {
    @Autowired
    private ReelService reelService;

    @RequestMapping(value = "/reel", method = RequestMethod.POST)
    public @ResponseBody Reel createReel(@RequestBody Reel reel) {
        return reelService.createReel(reel);
    }

    @RequestMapping(value = "/reels", method = RequestMethod.GET)
    public @ResponseBody List<Reel> getReels() {
        return reelService.getReels();
    }

    @RequestMapping(value = "/reel/{id}", method = RequestMethod.GET)
    public @ResponseBody Reel getReel(@PathVariable(value = "id") Long id) {
        return reelService.getReel(id);
    }

    @RequestMapping(value = "/reel", method = RequestMethod.PUT)
    public @ResponseBody Reel updateReel(@RequestBody Reel reel) {
        return reelService.updateReel(reel);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Object delete(@PathVariable(value = "id") Long id) {
        reelService.deleteReel(id);
        return null;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody Object test() {
        throw new DataAccessException("Testing exception thrown") {
        };
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ServiceError> handle(RuntimeException ex) {
        ServiceError error = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.OK);
    }
}
