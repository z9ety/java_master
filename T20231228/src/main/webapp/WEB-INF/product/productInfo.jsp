<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="images/${vo.image }" alt="..." /></div>
                    <div class="col-md-6">
                        <div class="small mb-1">${vo.productCode }</div>
                        <h1 class="display-5 fw-bolder">${vo.productName }</h1>
                        <div class="fs-5 mb-5">
                            <span class="text-decoration-line-through">${vo.originPrice }원</span>
                            <span>${vo.salePrice }원</span>
                        </div>
                        <p class="lead">${vo.productDesc }</p>
                        <div class="d-flex">
                            <input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                Add to cart
                            </button>
                        </div>
                    </div>
