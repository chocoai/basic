{"code":"${block.flag!''}",
[#assign msstr="保存失败"]
[#if "${block.flag!''}"=="8"][#assign msstr="保存成功"][/#if]
[#if "${block.flag!''}"=="3"][#assign msstr="保存失败"][/#if]
[#if "${block.flag!''}"=="2"][#assign msstr="数据主键为空，保存失败"][/#if]
[#if "${block.flag!''}"=="1"][#assign msstr="hbase链接成功，单保存失败"][/#if]
"message":"${msstr!''}"
}