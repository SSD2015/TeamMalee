/**
 * Created by neen_tta on 3/27/15 AD.
 */

// add image
$(function() {

    $('#dropzone').on('dragover', function() {
        $(this).addClass('hover');
    });

    $('#dropzone').on('dragleave', function() {
        $(this).removeClass('hover');
    });

    $('#dropzone input').on('change', function(e) {
        var file = this.files[0];

        $('#dropzone').removeClass('hover');

        if (this.accept && $.inArray(file.type, this.accept.split(/, ?/)) == -1) {
            return alert('File type not allowed.');
        }

        $('#dropzone').addClass('dropped');
        $('#dropzone img').remove();

        if ((/^image\/(gif|png|jpeg)$/i).test(file.type)) {
            var reader = new FileReader(file);

            reader.readAsDataURL(file);

            reader.onload = function(e) {
                var data = e.target.result,
                    $img = $('<img />').attr('src', data).fadeIn();

                $('#dropzone div').html($img);
            };
        } else {
            var ext = file.name.split('.').pop();

            $('#dropzone div').html(ext);
        }
    });
});

// add text
$(".mat-input").focus(function(){
    $(this).parent().addClass("is-active is-completed");
});

$(".mat-input").focusout(function(){
    if($(this).val() === "")
        $(this).parent().removeClass("is-completed");
    $(this).parent().removeClass("is-active");
})