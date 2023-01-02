package com.lolmatch.service

import com.lolmatch.entity.AccountInfo
import com.lolmatch.repository.AccountInfoRepository
import net.minidev.json.JSONArray
import net.minidev.json.JSONObject
import net.minidev.json.parser.JSONParser
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.BasicResponseHandler
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import java.util.stream.Collectors

@Service
class RiotService {

}