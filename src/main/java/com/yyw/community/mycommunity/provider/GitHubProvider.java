package com.yyw.community.mycommunity.provider;

import com.alibaba.fastjson.JSON;
import com.yyw.community.mycommunity.dto.AccessTokenDTO;
import com.yyw.community.mycommunity.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/**
 * @author Dantence
 * @date 2022/7/6
 */

@Component
public class GitHubProvider {
    /**
     * 主要是根据code字段来获取github的accessToken
     * @param accessTokenDTO
     * @return
     */
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType JSONTYPE = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)//连接超时
                .callTimeout(120, TimeUnit.SECONDS)//整个流程耗费的超时时间
                .pingInterval(5, TimeUnit.SECONDS)//websocket轮训间隔
                .readTimeout(60, TimeUnit.SECONDS)//读取超时
                .writeTimeout(60, TimeUnit.SECONDS)//写入超时
                .build();

        RequestBody body = RequestBody.create(JSONTYPE, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            return string.split("&")[0].split("=")[1];
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据accessToken获取github用户信息
     * @param accessToken
     * @return
     */
    public GitHubUser getGitHubUser(String accessToken){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)//连接超时
                .callTimeout(120, TimeUnit.SECONDS)//整个流程耗费的超时时间
                .pingInterval(5, TimeUnit.SECONDS)//websocket轮训间隔
                .readTimeout(60, TimeUnit.SECONDS)//读取超时
                .writeTimeout(60, TimeUnit.SECONDS)//写入超时
                .build();

        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization", "token "+accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            System.out.println(string);
            return JSON.parseObject(string, GitHubUser.class);
        } catch (IOException e){
        }
        return null;
    }
}
