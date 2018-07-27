package com.gyh.springboot.demo.web;

import com.gyh.springboot.demo.model.JsonResult;
import com.gyh.springboot.demo.model.Message;
import com.gyh.springboot.demo.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    /**
     * 新增文章
     * @param message
     * @return
     */
    @ApiOperation(value="新增文章", notes="根据model新增文章")
    @ApiImplicitParam(name = "message", value = "文章model", required = true, dataType = "Message")
    @RequestMapping(value = "message", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody Message message){
        JsonResult r = new JsonResult();
        try {
            r.setResult(message.getTitle());
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
