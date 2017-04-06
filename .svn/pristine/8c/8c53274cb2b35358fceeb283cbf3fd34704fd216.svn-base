<table border="0" width="100%" style="table-layout:fixed;background-color:#f0f0f0;line-height:30px;">
<tr>
<td align="right">${block.date?string("yyyy年MM月dd日")}&nbsp;
<span id="currentTime">${block.date?string("HH:mm:ss")}</span>
&nbsp;&nbsp;&nbsp;&nbsp;
[#if "${user.mem_id!''}"==""]
<a href="${block.authlogin}?client_id=${block.client_ID!''}">登录</a>
[#else]
欢迎您，${user.family_name!''}！&nbsp;&nbsp;
<a href="/portal/authclient.loginout">退出</a>
[/#if]
</td>
<td width="100px"></td>
</tr>
</table>
<script type="text/javascript"><!--
var now,hours,minutes,seconds,timeValue; 
function showtime(){
now = new Date();
now.setFullYear(${block.date?string("yyyy,MM,dd")});
hours = now.getHours(); 
minutes = now.getMinutes(); 
seconds = now.getSeconds(); 
timeValue = (hours >= 12) ? " 下午 " : " 上午 "; 
timeValue += ((hours > 12) ? hours - 12 : hours) + "点"; 
timeValue += ((minutes <10)?"0":"") + minutes+"分"; 
timeValue += ((seconds <10)?"0":"") + seconds+"秒"; 
$("#currentTime").html(timeValue); 
setTimeout("showtime()",100); 
} 
showtime();
// --></script>