/******/ (() => {
  // webpackBootstrap
  /******/ "use strict";
  var __webpack_exports__ = {};
  /*!***********************************************************!*\
  !*** ../demo2/src/js/pages/custom/login/login-general.js ***!
  \***********************************************************/

  // Class Definition
  var KTLogin = (function () {
    var _login;

    var _showForm = function (form) {
      var cls = "login-" + form + "-on";
      var form = "kt_login_" + form + "_form";

      _login.removeClass("login-forgot-on");
      _login.removeClass("login-signin-on");
      _login.removeClass("login-signup-on");

      _login.addClass(cls);

      KTUtil.animateClass(
        KTUtil.getById(form),
        "animate__animated animate__backInUp"
      );
    };

    var _handleSignInForm = function () {
      var validation;

      // Init form validation rules. For more info check the FormValidation plugin's official documentation:https://formvalidation.io/
      validation = FormValidation.formValidation(
        KTUtil.getById("kt_login_signin_form"),
        {
          fields: {
            username: {
              validators: {
                notEmpty: {
                  message: "Nombre de usuario requerido.",
                },
              },
            },
            email: {
              validators: {
                notEmpty: {
                  message: "Correo electrónico requerido.",
                },
                emailAddress: {
                  message: "Ingresa un correo electrónico válido.",
                },
              },
            },
            password: {
              validators: {
                notEmpty: {
                  message: "Contraseña requerida.",
                },
              },
            },
          },
          plugins: {
            trigger: new FormValidation.plugins.Trigger(),
            submitButton: new FormValidation.plugins.SubmitButton(),
            //defaultSubmit: new FormValidation.plugins.DefaultSubmit(), // Uncomment this line to enable normal button submit after form validation
            bootstrap: new FormValidation.plugins.Bootstrap(),
          },
        }
      );

      $("#kt_login_signin_submit").on("click", function (e) {
        e.preventDefault();

        validation.validate().then(function (status) {
          if (status == "Valid") {
            swal
              .fire({
                text: "¡Todo está bien! Enviando formulario.",
                icon: "success",
                buttonsStyling: false,
                confirmButtonText: "Ok, ¡lo tengo!",
                customClass: {
                  confirmButton: "btn font-weight-bold btn-light-primary",
                },
              })
              .then(function () {
                KTUtil.scrollTop();
              });
          } else {
            swal
              .fire({
                text:
                  "Lo sentimos, parece que se han detectado algunos errores. Vuelve a intentarlo.",
                icon: "error",
                buttonsStyling: false,
                confirmButtonText: "Ok, ¡lo tengo!",
                customClass: {
                  confirmButton: "btn font-weight-bold btn-light-primary",
                },
              })
              .then(function () {
                KTUtil.scrollTop();
              });
          }
        });
      });

      // Handle forgot button
      $("#kt_login_forgot").on("click", function (e) {
        e.preventDefault();
        _showForm("forgot");
      });

      // Handle signup
      $("#kt_login_signup").on("click", function (e) {
        e.preventDefault();
        _showForm("signup");
      });
    };

    var _handleSignUpForm = function (e) {
      var validation;
      var form = KTUtil.getById("kt_login_signup_form");

      // Init form validation rules. For more info check the FormValidation plugin's official documentation:https://formvalidation.io/
      validation = FormValidation.formValidation(form, {
        fields: {
          fullname: {
            validators: {
              notEmpty: {
                message: "Nombre de usuario requerido.",
              },
            },
          },
          email: {
            validators: {
              notEmpty: {
                message: "Correo electrónico requerido.",
              },
              emailAddress: {
                message: "Ingresa un correo electrónico válido.",
              },
            },
          },
          password: {
            validators: {
              notEmpty: {
                message: "Contraseña requerida.",
              },
            },
          },
          cpassword: {
            validators: {
              notEmpty: {
                message: "Confirmación de contraseña requerida.",
              },
              identical: {
                compare: function () {
                  return form.querySelector('[name="password"]').value;
                },
                message: "Las contraseñas son diferentes.",
              },
            },
          },
          agree: {
            validators: {
              notEmpty: {
                message:
                  "Debes aceptar los Términos, Condiciones y Políticas para continuar.",
              },
            },
          },
        },
        plugins: {
          trigger: new FormValidation.plugins.Trigger(),
          bootstrap: new FormValidation.plugins.Bootstrap(),
        },
      });

      $("#kt_login_signup_submit").on("click", function (e) {
        e.preventDefault();

        validation.validate().then(function (status) {
          if (status == "Valid") {
            swal
              .fire({
                text: "¡Todo está bien! Enviando formulario.",
                icon: "success",
                buttonsStyling: false,
                confirmButtonText: "Ok, ¡lo tengo!",
                customClass: {
                  confirmButton: "btn font-weight-bold btn-light-primary",
                },
              })
              .then(function () {
                KTUtil.scrollTop();
              });
          } else {
            swal
              .fire({
                text:
                  "Lo sentimos, parece que se han detectado algunos errores. Vuelve a intentarlo.",
                icon: "error",
                buttonsStyling: false,
                confirmButtonText: "Ok, ¡lo tengo!",
                customClass: {
                  confirmButton: "btn font-weight-bold btn-light-primary",
                },
              })
              .then(function () {
                KTUtil.scrollTop();
              });
          }
        });
      });

      // Handle cancel button
      $("#kt_login_signup_cancel").on("click", function (e) {
        e.preventDefault();

        _showForm("signin");
      });
    };

    var _handleForgotForm = function (e) {
      var validation;

      // Init form validation rules. For more info check the FormValidation plugin's official documentation:https://formvalidation.io/
      validation = FormValidation.formValidation(
        KTUtil.getById("kt_login_forgot_form"),
        {
          fields: {
            email: {
              validators: {
                notEmpty: {
                  message: "Correo electrónico requerido.",
                },
                emailAddress: {
                  message: "Ingresa un correo electrónico válido.",
                },
              },
            },
          },
          plugins: {
            trigger: new FormValidation.plugins.Trigger(),
            bootstrap: new FormValidation.plugins.Bootstrap(),
          },
        }
      );

      // Handle submit button
      $("#kt_login_forgot_submit").on("click", function (e) {
        e.preventDefault();

        validation.validate().then(function (status) {
          if (status == "Valid") {
            // Submit form
            KTUtil.scrollTop();
          } else {
            swal
              .fire({
                text:
                  "Lo sentimos, parece que se han detectado algunos errores. Vuelve a intentarlo.",
                icon: "error",
                buttonsStyling: false,
                confirmButtonText: "Ok, ¡lo tengo!",
                customClass: {
                  confirmButton: "btn font-weight-bold btn-light-primary",
                },
              })
              .then(function () {
                KTUtil.scrollTop();
              });
          }
        });
      });

      // Handle cancel button
      $("#kt_login_forgot_cancel").on("click", function (e) {
        e.preventDefault();

        _showForm("signin");
      });
    };

    // Public Functions
    return {
      // public functions
      init: function () {
        _login = $("#kt_login");

        _handleSignInForm();
        _handleSignUpForm();
        _handleForgotForm();
      },
    };
  })();

  // Class Initialization
  jQuery(document).ready(function () {
    KTLogin.init();
  });

  /******/
})();
//# sourceMappingURL=login-general.js.map
