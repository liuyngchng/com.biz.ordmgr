function updateBaofooStatus() {
    var baofooPayNo = $("#baofooPayNo").val();
    var contextParam = $("#contextParam").val();

    $.ajax({
        url: contextParam + '/emergency/baofoo',
        type: 'post',
        dataType: 'json',
        data: {
            baofooPayNo : baofooPayNo
        },
        success: function(data) {
            alert(JSON.stringify(data));
            return false;
        },
        error: function (data) {
            alert(JSON.stringify(data));
            return false;
        }
    })
}

function updateAuditStatus() {
    var contextParam = $("#contextParam").val();
    $.ajax({
        url: contextParam + '/emergency/auditStatus/update',
        type: 'post',
        dataType: 'json',
        data: {
            applyNo : $("#applyNo").val(),
            auditStatus : $("#auditStatus").val()
        },
        success: function(data) {
            alert(JSON.stringify(data["responseText"]));
            return true;
        },
        error: function (data) {
            alert(JSON.stringify(data["responseText"]));
            return false;
        }
    })
}