<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.toaudio.dto.BoardDTO" %>
<%@ page import="com.toaudio.dao.BoardDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Audio Player</title>
<link href="./style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
window.onload = function(){
	var audio = document.getElementById('audio');
	
	var play = document.getElementById('play');
	var pause = document.getElementById('pause');
	var volUp = document.getElementById('volUp');
	var volDown = document.getElementById('volDown');
	var slow = document.getElementById('slow');
	var fast = document.getElementById('fast');
	var back = document.getElementById('back');
	var forward = document.getElementById('forward');
	
	play.addEventListener("click", function(){
	    audio.play();
	});
	pause.addEventListener("click", function(){
	    audio.pause();
	});
	
	volUp.addEventListener("click", function(){
		if(audio.volume < 1){
			audio.volume = (audio.volume * 10 + 1) / 10;
		}
		console.log(audio.volume);
	});
	volDown.addEventListener("click", function(){
		if(audio.volume > 0){
			audio.volume = (audio.volume * 10 - 1) / 10;
		}
		console.log(audio.volume);
	});
	slow.addEventListener("click", function(){
	    if(audio.playbackRate > 0.5){
			audio.playbackRate -= 0.5;
	    }
	    console.log(audio.playbackRate);
	});
	fast.addEventListener("click", function(){
		if(audio.playbackRate < 3.0){
			audio.playbackRate += 0.5;
	    }
		console.log(audio.playbackRate);
	});
	back.addEventListener("click", function(){
	    audio.currentTime -= 10;
	});
	forward.addEventListener("click", function(){
	    audio.currentTime += 10;
	});
}
</script>
</head>
<body>
	<div class="container">
		<table>
			<thead>
				<tr>
					<th colspan="2">${player.title }</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>아이디</td>
					<td>${player.m_id }</td>
				</tr>
				<tr>
					<td>업로드 시간</td>
					<td>${player.update_time }</td>
				</tr>
				<tr>
					<td colspan="2">
						<audio id="audio" controls="controls" src="${player.realpath }" preload="metadata"></audio>
						<br>
						<button id="play">재생</button>
						<button id="pause">일시정지</button>
						<button id="volUp">소리 크게</button>
						<button id="volDown">소리 작게</button>
						<br>
						<button id="slow">느리게</button>
						<button id="fast">빠르게</button>
						<button id="back">10초 뒤로</button>
						<button id="forward">10초 앞으로</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>