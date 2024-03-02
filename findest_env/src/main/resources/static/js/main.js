$(document).ready(function() {
    // Lorsqu'un bouton de suppression est cliqué
    $('.btn-danger').on('click', function() {
        var studyId = $(this).data('id'); 
        $('#deleteConfirmBtn').data('id', studyId);
    });

    // Lorsque le bouton "Yes" du modal est cliqué
    $('#deleteConfirmBtn').on('click', function() {
        var id = $(this).data('id'); // Récupérez l'ID stocké
        window.location.href = '/removeStudy/' + id; // Redirigez pour effectuer la suppression
    });
});
