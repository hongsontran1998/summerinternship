$(function () {
    console.log("page-script");

    //setup ajax csrf
    let token = $("meta[name='_csrf']").attr("content");
    let header = $("meta[name='_csrf_header']").attr("content");
    console.log(token);
    console.log(header);
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });

    $.ajax({
        url: 'api/category',
        type: 'GET',
        cache: false,
        data: {},
        success: function(response){
            console.log(response);
        },
        error: function (){
            console.log("ajax error");
        }
    });
});