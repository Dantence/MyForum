/**
 * 提交回复
 */
function comment2target(targetId, type, content) {
    if (!content) {
        alert("您还没有输入内容喔~")
        return
    }

    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": targetId,
            "content": content,
            "type": type
        }),
        success: function (response) {
            if (response.code === 200) {
                $("#comment_section").hide()
                window.location.reload()
            } else {
                if (response.code === 2003) {
                    let isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=87df8eadcb6e3f32612f&redirect_url=http://localhost:8080/callback&scope=user&state=1")
                        window.localStorage.setItem("close", "1")

                    }
                } else {
                    alert(response.message)
                }
            }
        },
        dataType: "json"
    })
}

function doComment() {
    let content = $("#comment_content").val()
    let parentId = getParentId()
    comment2target(parentId, 1, content)
}

function comment(e) {
    let commentId = e.getAttribute("data-id")
    let content = $("#input-" + commentId).val()
    comment2target(commentId, 2, content)
}

function getParentId() {
    let url = window.location.pathname
    let index = url.lastIndexOf("/")
    return parseInt(url.substr(index + 1))
}

/**
 * 展开二级评论
 */
function collapseComments(e) {
    let id = e.getAttribute("data-id")
    let isCollapsein = e.getAttribute("data-collapsein")

    if (isCollapsein === "false") {
        let subCommentContainer = $("#comment-" + id)
        if (subCommentContainer.children().length === 1) {
            $.getJSON("/comment/" + id, function (data) {
                $.each(data.data.reverse(), function (index, comment) {
                    let mediaLeftElement = $("<div/>", {
                        "class": "media-left"
                    }).append($("<img/>", {
                        "class": "media-object img-size",
                        "src": comment.user.avatarUrl
                    }))
                    let mediaBodyElement = $("<div/>", {
                        "class": "media-body comment-body"
                    }).append($("<h4/>", {
                        "class": "media-heading",
                        "html": comment.user.name,
                        "href": "/profile/" + comment.user.id
                    })).append($("<div/>", {
                        "html": comment.content
                    })).append($("<div/>", {
                        "class": "comment-menu"
                    }).append($("<div/>", {
                        "class": "pull-right",
                        "html": moment(comment.gmtCreate).format('YYYY-MM-DD HH:mm')
                    })).append($("<span/>", {
                        "class": "glyphicon glyphicon-thumbs-up comment-icon"
                    })))

                    let mediaElement = $("<div/>", {
                        "class": "media"
                    }).append(mediaLeftElement).append(mediaBodyElement)

                    let commentElement = $("<div/>", {
                        "class": "col-lg-12 col-md-12 col-sm-12 col-xs-12 comment-list",
                    }).append(mediaElement);
                    subCommentContainer.prepend(commentElement)
                });

            })
        }
        //展开二级评论
        subCommentContainer.addClass("in")
        e.setAttribute("data-collapsein", "true")
        e.classList.add("active")
    } else {
        $("#comment-" + id).removeClass("in")
        e.setAttribute("data-collapsein", "false")
        e.classList.remove("active")
    }

}

function selectTag(val) {
    let tag = val.innerHTML
    let previous = $("#tag").val()
    if (previous.indexOf(tag) !== -1) {
        alert("您已经添加过该标签了哦~")
    } else {
        if (previous) {
            $("#tag").val(previous + ',' + tag)
        } else {
            $("#tag").val(tag)
        }
    }
}

function showSelectTag() {
    $("#select-tag").show()
}

function doFollow(e) {
    let follow_id = e.getAttribute("data-follow_id")
    let fan_id = e.getAttribute("data-fan_id");
    let follow_btn = $("#follow-btn")
    if(follow_btn.hasClass("follow-btn")) {
        $.ajax({
            type: "POST",
            url: "/follow",
            data: {
                "followId": follow_id,
                "fanId": fan_id,
            },
            success: function (response) {
                if (response.code === 200) {
                    let fanCount = response.data
                    $("#fanCount").text(fanCount)
                    follow_btn.attr("class", "msg-btn")
                    follow_btn.html("取消关注")
                } else {
                    alert("关注失败!")
                }
            },
            dataType: "json"
        })
    } else {
        $.ajax({
            type: "POST",
            url: "/unfollow",
            data: {
                "followId": follow_id,
                "fanId": fan_id,
            },
            success: function (response) {
                if (response.code === 200) {
                    let fanCount = response.data
                    $("#fanCount").text(fanCount)
                    follow_btn.attr("class", "follow-btn")
                    follow_btn.html("+关注")
                } else {
                    alert("取关失败!")
                }
            },
            dataType: "json"
        })
    }

}