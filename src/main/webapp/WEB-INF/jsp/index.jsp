<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Index</title>
    <script src="<c:url value='/js/jquery.min.js' />"></script>
    <script src="<c:url value='/js/jquery-3.0.0.min.js' />"></script>
    <script src="<c:url value='/js/bootstrap.js' />"></script>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <script type="text/javascript">
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
            $("#addUserBtn").click(function () {
                $.ajax({
                    type: "GET",
                    url: "selectAllSitesAjax",
                    dataType: "json",
                    success: function (response) {
                        $("#ajaxPrepend").empty();
                        for (var i = 0; i < response.length; i++) {
                            $("#ajaxPrepend").prepend('<input type="checkbox" name="sitesId" value="' + response[i].sid + '">' + response[i].name + '');
                        }
                    },
                    error: function (xhr, ajaxOptions, thrownError) {
                        alert(xhr.status + "\n" + thrownError);
                    }
                });
            })
        });
    </script>
</head>
<body>


<table border="1">
    <tr>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addSiteModal">
            新增站點
        </button>
    </tr>
    <tr>
        <form method="get" action="/selectAllSites">
            <button type="submit" class="btn btn-primary">站點列表</button>
        </form>
    </tr>
    <tr>
        <button id="addUserBtn" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addUserModal">
            新增護士
        </button>
    </tr>
    <tr>
        <form method="get" action="/selectAllUsers">
            <button type="submit" class="btn btn-primary">護士列表</button>
        </form>
    </tr>
</table>


<!-- 新增員工編號 護士姓名 model -->
<div id="addUserModal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h3>新增護士</h3>
                <button type="button" class="close btn-warning"
                        data-dismiss="modal">&times;
                </button>
            </div>
            <div class="modal-body" style="font-size:24px;" class="col-sm-12 text-center align-self-center">
                <form method="get" action="addUser"
                      enctype="multipart/form-data">
                    <table cellspacing="10">
                        <tr>
                            <td>員工編號：</td>
                            <td><input id="user_staffId" type="text" name="staffId"></td>
                        </tr>
                        <tr>
                            <td>護士姓名：</td>
                            <td><input id="user_name" type="text" name="name"></td>
                        </tr>
                        <tr>
                            <td>分配站點：</td>
                            <td>
                                <div id="ajaxPrepend"></div>
                            </td>
                        </tr>
                    </table>
                    <div style="padding:20px 0px 0px 10px">
                        <input class="btn btn-lg btn-warning" type="submit" value="新增護士"/>
                    </div>
                </form>
            </div>
            <div class="modal-footer"></div>
        </div>
    </div>
</div>
<!-- /對話盒 -->
<!-- 新增站點對話盒 -->
<div id="addSiteModal" class="modal fade" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h3>新增站點</h3>
                <button type="button" class="close btn-warning"
                        data-dismiss="modal">&times;
                </button>
            </div>
            <div class="modal-body" style="font-size:20px;" class="col-sm-12 text-center align-self-center">
                <form method="get" action="addSite"
                      enctype="multipart/form-data">
                    <table>
                        <tr>
                            <td><label><h2>站點名稱：</h2></label></td>
                            <td><input id="side_name" type="text" name="name"></td>
                        </tr>
                    </table>
                    <div style="padding:20px 0px 0px 10px">
                        <input class="btn btn-lg btn-warning" type="submit" value="新增"/>
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