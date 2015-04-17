/**
 * Created by neen_tta on 3/27/15 AD.
 */



// add text
$( function() {
        $(".mat-input").focus(function () {
            $(this).parent().addClass("is-active is-completed");
        });

        $(".mat-input").focusout(function () {
            if ($(this).val() === "")
                $(this).parent().removeClass("is-completed");
            $(this).parent().removeClass("is-active");
        })
    }
)