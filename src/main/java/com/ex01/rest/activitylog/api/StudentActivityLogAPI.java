package com.ex01.rest.activitylog.api;

import com.ex01.module.activitylogmodule.dto.ActivityLogCreateDTO;
import com.ex01.module.activitylogmodule.dto.ActivityLogDTO;
import com.ex01.module.activitylogmodule.model.ActivityLogModel;
import com.ex01.module.activitylogmodule.service.ActivityLogService;
import com.ex01.module.activitylogmodule.utils.domain.JsonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "StudentActivityLog")
@RestController
@RequestMapping("/ex01/log")
public class StudentActivityLogAPI {

    @Autowired
    private ActivityLogService activityLogService;

    private Logger logger = LoggerFactory.getLogger(StudentActivityLogAPI.class);

    @ApiOperation(value = "This is an example of Rest API Endpoint")
    @ApiResponses(value = { @ApiResponse(code = 200, response = String.class, message = "Success") })
    @RequestMapping(value = "/search/{pageStart}/{pageSize}", method = RequestMethod.GET)
    public ResponseEntity<?> search(@PathVariable int pageStart, @PathVariable int pageSize){
        List<ActivityLogModel> results = new ArrayList<>();
        Page<ActivityLogModel> resultsIterator = activityLogService.search(pageStart, pageSize);
        JsonResponse jsonResponse = new JsonResponse(resultsIterator.getContent(), true);
        return new ResponseEntity<JsonResponse>(jsonResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "This is an example of Rest API Endpoint")
    @ApiResponses(value = { @ApiResponse(code = 200, response = String.class, message = "Success") })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody(required=false) ActivityLogCreateDTO request){
        ActivityLogCreateDTO data = activityLogService.add(request);
        JsonResponse jsonResponse = new JsonResponse(data, true);
        return new ResponseEntity<JsonResponse>(jsonResponse, HttpStatus.CREATED);
    }

    @ApiOperation(value = "This is an example of Rest API Endpoint")
    @ApiResponses(value = { @ApiResponse(code = 200, response = String.class, message = "Success") })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> update(@RequestBody(required=false) ActivityLogDTO request){
        ActivityLogDTO datas = activityLogService.update(request);
        JsonResponse jsonResponse = new JsonResponse(datas, true);
        return new ResponseEntity<JsonResponse>(jsonResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "This is an example of Rest API Endpoint")
    @ApiResponses(value = { @ApiResponse(code = 200, response = String.class, message = "Success") })
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable String id){
        boolean success = activityLogService.delete(id);
        JsonResponse jsonResponse = new JsonResponse(success);
        return new ResponseEntity<JsonResponse>(jsonResponse, HttpStatus.OK);
    }
}
