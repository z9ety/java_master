<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	${plist}
<c:forEach var="Pvo" items="${plist}">
	<div class="col mb-5">
		<div class="card h-100">
			<div class="badge bg-dark text-white position-absolute"
				style="top: 0.5rem; right: 0.5rem">Sale</div>
			<img class="card-img-top"
				src="${Pvo.image }" alt="..." />
			<div class="card-body p-4">
				<div class="text-center">
					<h5 class="fw-bolder"><a href="getProduct.do?pcode=${Pvo.pcode}">${Pvo.pname }</a></h5>
					<div class="d-flex justify-content-center small text-warning mb-2">
						<div class="bi-star-fill"></div>
						<div class="bi-star-fill"></div>
						<div class="bi-star-fill"></div>
						<div class="bi-star-fill"></div>
						<div class="bi-star-fill"></div>
					</div>
					<span class="text-muted text-decoration-line-through">${Pvo.oprice }원</span>
					${Pvo.sprice}원
				</div>
			</div>
			<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
				<div class="text-center">
					<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
				</div>
			</div>
		</div>
	</div>
</c:forEach>