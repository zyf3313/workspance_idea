/**
 * Created by scc on 2018/8/22.
 */

/**
 * 初始化函数
 */
$(function(){
    loadBalance();
})



/**
 * 打开充值弹出框
 */
function openRecharge(){

}

/**
 * 加载余额
 */
function loadBalance(){
    $.ajax({
        type:"get",
        url:"pay/account/queryBalance",
        dataType:"text",
        success:function(data){
            $("#balance").html("<em class='h3 text-red-deep'>"+data +"</em>");
        }
    });
}