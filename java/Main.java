import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiAttendanceListscheduleRequest;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiAttendanceListscheduleResponse;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.htzs.pms.Token;
import com.taobao.api.ApiException;

import java.io.IOException;
import java.util.Date;

/**
 * @author: Earle
 * @createdDate: 2019-8-2
 * @updatedDate:
 */
public class Main {

    public static void main(String[] args) throws ApiException, IOException {

        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey("获取步骤的六的 AppKey");
        request.setAppsecret("获取步骤六的 AppSecret");
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        System.out.println(response.getBody());
        ObjectMapper objectMapper = new ObjectMapper();
        // 创建了一个 Token
        Token token = objectMapper.readValue(response.getBody(), Token.class);
        // 打印出 access_token
        System.out.println(token.getAccess_token());


        DingTalkClient client1 = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/attendance/listschedule");
        OapiAttendanceListscheduleRequest request1 = new OapiAttendanceListscheduleRequest();
        request1.setWorkDate(new Date());
        request1.setOffset(0L);
        request1.setSize(1L);
        OapiAttendanceListscheduleResponse execute = client1.execute(request1, token.getAccess_token());
        System.out.println(execute);
 /*       DefaultDingTalkClient client1 = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/attendance/getsimplegroups");
        OapiAttendanceGetsimplegroupsRequest request1 = new OapiAttendanceGetsimplegroupsRequest();
        OapiAttendanceGetsimplegroupsResponse execute = client1.execute(request1, token.getAccess_token());
        System.out.println(execute);*/

        /*DingTalkClient client1 = new DefaultDingTalkClient("https://oapi.dingtalk.com/attendance/listRecord");
        OapiAttendanceListRecordRequest request1 = new OapiAttendanceListRecordRequest();
        request1.setCheckDateFrom("2019-07-01 00:00:00");
        request1.setCheckDateTo("2019-07-05 00:00:00");
        request1.setUserIds(Arrays.asList("员工 id"));
        OapiAttendanceListRecordResponse execute = client1.execute(request1, token.getAccess_token());
        System.out.println(execute);*/
    /*    DingTalkClient client1 = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/get");
        OapiUserGetRequest request1 = new OapiUserGetRequest();
        request1.setUserid("员工 id");
        request1.setHttpMethod("GET");
        OapiUserGetResponse res = client1.execute(request1, token.getAccess_token());
        System.out.println(res);*/

    }
}
