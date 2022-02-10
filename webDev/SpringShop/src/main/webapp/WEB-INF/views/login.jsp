<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main class="container">
  <form action="/loginGo" method="post">
    <img class="mb-4" src="/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

    <div class="form-floating">
      <input type="text" class="form-control" name="mi_id" id="floatingInput" placeholder="id">
      <label for="floatingInput">ID</label>
    </div>
    <div class="form-floating">
      <input type="password" name="mi_pw" class="form-control" id="floatingPassword" placeholder="Password">
      <label for="floatingPassword">Password</label>
    </div>

    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> Remember me
      </label>
    </div>
     <button class="w-49 btn btn-lg btn-primary" type="submit">Sign in</button>
     <a href="/joinMember" class="w-49 btn btn-lg btn-primary" >Sign up</a>
    <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
  </form>
</main>


