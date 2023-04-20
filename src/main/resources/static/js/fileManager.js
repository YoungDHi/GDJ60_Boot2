
$('#fileAddBtn').click(function(){
    console.log('click')
    //<input type="file" name="boardFiles">
    let html = '<input type="file" name="boardFiles">';
    $('#fileAdd').append(html)
})