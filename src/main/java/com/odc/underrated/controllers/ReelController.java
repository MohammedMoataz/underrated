package com.odc.underrated.controllers;

import com.odc.underrated.dtos.req.ReelReq;
import com.odc.underrated.dtos.res.ReelRes;
import com.odc.underrated.services.ReelService;
import com.odc.underrated.util.ServiceError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReelController {
    @Autowired
    private ReelService reelService;

    @RequestMapping(value = "/reel/", method = RequestMethod.POST)
    public @ResponseBody ReelRes createReel(@RequestBody ReelReq reelReq) {
        return reelService.save(reelReq);
    }

    @RequestMapping(value = "/reels", method = RequestMethod.GET)
    public @ResponseBody List<ReelRes> getReels() {
        return reelService.findAll();
    }

    @RequestMapping(value = "/reel/{id}", method = RequestMethod.GET)
    public @ResponseBody ReelRes getReel(@PathVariable(value = "id") String id) {
        return reelService.findById(id);
    }

    @RequestMapping(value = "/reel/{id}", method = RequestMethod.PUT)
    public @ResponseBody ReelRes updateReel(@PathVariable(value = "id") String id, @RequestBody ReelReq reelReq) {
        return reelService.updateReel(id, reelReq);
    }

    @RequestMapping(value = "/reel/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Object delete(@PathVariable(value = "id") String id) {
        reelService.deleteById(id);
        return null;
    }

    @RequestMapping(value = "/reel/test", method = RequestMethod.GET)
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