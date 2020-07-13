document.write("<script src='/static/layui/layui.js'></script>");
var layer;
layui.use('layer',function () {
    layer = layui.layer;
})
//获取地址栏参数
function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}

function hasText(str) {
    if (str != undefined && str != null)
        return str.trim() != "";
    return false;
}

function inputHasValueByName(name) {
    var val = $("input[name='"+name+"']").val();
    return hasText(val);
}

function inputHasValueById(id) {
    var val = $("#"+id+"").val();
    return hasText(val);
}

function buildXxx(json) {
    /**
     * 解析json然后构造Xxx
     */
}

function dealBaseDto(data,callback) {
    if (!data.success)
    {
        layer.msg(data.errorMsg,{icon:2});
    }
    else
    {
        callback(data.data);
    }
}