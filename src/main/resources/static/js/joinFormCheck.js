/**
 *  Join Form에서 검증
 */

$('#userName').blur(idDuplicateCheck)

$('#passwordCheck').blur(function(){
    if($(this).val()==$('#password').val()){
        $('#passwordCheckResult').html('비밀번호가 일치합니다')
    } else {
        $('#passwordCheckResult').html('동일한 비밀번호를 입력해주세요')
    }
})

function idDuplicateCheck(){
    $.ajax({
        type : "GET",
        url : "./idDuplicateCheck",
        data : {
            userName : $('#userName').val()
        },
        success : function(result){
            if(result==1){
                console.log('사용할 수 있는 ID입니다')
             } else {
                console.log('중복된 ID입니다')   
            }
        },
        error : function(){
            console.log('error')
        }
        
    })
}

