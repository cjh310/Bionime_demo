<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Index</title>
    <script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script>
        $(document).ready(function () {
            <c:if test="${not empty message}">
            Swal.fire({
                position: 'top-end',
                <c:if test="${status eq '0'}">
                icon: 'success',
                </c:if>
                <c:if test="${status eq '1'}">
                icon: 'warning',
                </c:if>
                title: "${message}",
                showConfirmButton: false,
                timer: 1500

            })
            </c:if>
        });
    </script>
    <script type="text/javascript">
        function viewUser(uid) {
            $("#getUserInfo").modal();
            $.ajax({
                type: "GET",
                url: "selectUser",
                data: "uid=" + uid,
                dataType: "json",
                success: function (response) {
                    $("tr").remove(".delClass");
                    $("#uesr_uid").val(response.uid);
                    $("#user_staffId").val(response.staffId);
                    $("#user_name").val(response.name);
                    $("#ajaxPrepend").empty();
                    response.allSitesInfo.forEach(function (data) {
                        $("#ajaxPrepend").prepend('<input type="checkbox" id="sid'+data.sid+'" name="sitesId" value="' + data.sid + '">' + data.name + '');
                    })

                    response.siteInfo.forEach(function (data) {
                        var sidStr="#sid"+data.sid;
                        $(sidStr).prop('checked', true);
                    })

                },
                error: function (xhr, ajaxOptions, thrownError) {
                    alert(xhr.status + "\n" + thrownError);
                }
            });
        }

        function delUser(uid) {
            var form = $('<form action="delUser" method="GET">'
                + '<input type="hidden" name="uid" value="'
                + uid + '" />' + '</form>');
            $('body').append(form);
            form.submit();
        }
    </script>
</head>
<body>
<div class="text-center align-self-center">
    <h3>護士列表</h3>
    <table border="1" width="30%" style="font-size:20px;" align="center" class="text-center">
        <tr>
            <td><b>員編</b></td>
            <td><b>修改時間</b></td>
            <td><b>動作</b></td>
        </tr>
        <c:forEach var="user" items="${allUsers}">
            <tr>
                <td>${user.staffId}</td>
                <td><fmt:formatDate value="${user.modifyTime}" pattern=" yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <button type="button" class="btn btn-lg btn-info" onclick="viewUser(${user.uid})">
                        View
                    </button>
                    <button class="btn btn-lg btn-danger" onclick="delUser(${user.uid})">Del</button>
                </td>
            </tr>
        </c:forEach>


    </table>
    <form method="get" action="index">
        <button class="btn btn-primary" type="submit">返回</button>
    </form>
</div>

<!-- 查看護士 modal -->
<div id="getUserInfo" class="modal fade" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h3>查看護士</h3>
                <button type="button" class="close btn-warning"
                        data-dismiss="modal">&times;
                </button>
            </div>
            <div style="font-size:24px;" class="modal-body col-sm-12 text-center align-self-center">
                <form method="get" action="updateUser"
                      enctype="multipart/form-data">
                    <table cellspacing="10">
                        <input id="uesr_uid" type="hidden" name="uid">
                        <tr>
                            <td>員工編號：</td>
                            <td><input id="user_staffId" type="text" name="staffId" value="A12"></td>
                        </tr>
                        <tr>
                            <td>護士姓名：</td>
                            <td><input id="user_name" type="text" name="name" value="TESTNAME"></td>
                        </tr>
                        <tr>
                            <td>分配站點：</td>
                            <td>
                                <div id="ajaxPrepend"></div>
                            </td>
                        </tr>
                    </table>
                    <div style="padding:20px 0px 0px 10px">
                        <input class="btn btn-lg btn-warning" type="submit" value="編輯護士"/>
                    </div>
                </form>
            </div>
            <div class="modal-footer"></div>
        </div>
    </div>
</div>
<!-- /對話盒 -->

</body>

</html>