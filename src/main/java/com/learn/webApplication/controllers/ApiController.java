package com.learn.webApplication.controllers;

import com.learn.webApplication.dao.PurgeListDao;
import com.learn.webApplication.models.PurgeList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by z002v2f on 17/11/17.
 */
@RestController
public class ApiController {

    private final Logger LOG = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private PurgeListDao purgeListDao;

    @RequestMapping(value = "/v1/purgeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPurgeList() {
        LOG.debug("Get PurgeList Called.");
        List<PurgeList> list = null;
        try {
            list = purgeListDao.getMdmSeqIds();
        }catch (Exception e){
            LOG.error("Got Error in getting list", e);
        }
        LOG.debug("Got the Purge List");
        final ResponseEntity<Object> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);

        return responseEntity;
    }

}
