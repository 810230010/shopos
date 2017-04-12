/*!
 * bootstrap-fileinput v4.3.9
 * http://plugins.krajee.com/file-input
 *
 * Font Awesome icon theme configuration for bootstrap-fileinput. Requires font awesome assets to be loaded.
 *
 * Author: Kartik Visweswaran
 * Copyright: 2014 - 2017, Kartik Visweswaran, Krajee.com
 *
 * Licensed under the BSD 3-Clause
 * https://github.com/kartik-v/bootstrap-fileinput/blob/master/LICENSE.md
 */
(function ($) {
    "use strict";

    var STYLE_SETTING = 'style="width:{width};height:{height};"';
    var DEFAULT_PREVIEW = '<div class="file-preview-other">\n' +
        '<span class="{previewFileIconClass}">{previewFileIcon}</span>\n' +
        '</div>';
    var OBJECT_PARAMS = '<param name="controller" value="true" />\n' +
        '<param name="allowFullScreen" value="true" />\n' +
        '<param name="allowScriptAccess" value="always" />\n' +
        '<param name="autoPlay" value="false" />\n' +
        '<param name="autoStart" value="false" />\n' +
        '<param name="quality" value="high" />\n';

    var tTagBef = '<div class="file-preview-frame krajee-default  kv-preview-thumb" id="{previewId}" data-fileindex="{fileindex}"' +
        ' data-template="{template}"';
    var tTagBef1 = tTagBef + '><div class="kv-file-content">\n';
    var tTagBef2 = tTagBef + ' title="{caption}" ' + STYLE_SETTING + '><div class="kv-file-content">\n';
    var tTagAft = '</div>{footer}\n</div>\n';

    var tGeneric = '{content}\n';
    var tHtml = '<div class="kv-preview-data file-preview-html" title="{caption}" ' + STYLE_SETTING + '>{data}</div>\n';
    var tImage = '<img src="{data}" class="kv-preview-data file-preview-image" title="{caption}" alt="{caption}" ' +
        STYLE_SETTING + '>\n';
    var tText = '<textarea class="kv-preview-data file-preview-text" title="{caption}" readonly ' + STYLE_SETTING +
        '>{data}</textarea>\n';
    var tVideo = '<video class="kv-preview-data" width="{width}" height="{height}" controls>\n' +
        '<source src="{data}" type="{type}">\n' + DEFAULT_PREVIEW + '\n</video>\n';
    var tAudio = '<audio class="kv-preview-data" controls>\n<source src="' + '{data}' + '" type="{type}">\n' +
        DEFAULT_PREVIEW + '\n</audio>\n';
    var tFlash = '<object class="kv-preview-data file-object" type="application/x-shockwave-flash" ' +
        'width="{width}" height="{height}" data="{data}">\n' + OBJECT_PARAMS + ' ' + DEFAULT_PREVIEW + '\n</object>\n';
    var tObject = '<object class="kv-preview-data file-object" data="{data}" type="{type}" width="{width}" height="{height}">\n' +
        '<param name="movie" value="{caption}" />\n' + OBJECT_PARAMS + ' ' + DEFAULT_PREVIEW + '\n</object>\n';
    var tPdf = '<embed class="kv-preview-data" src="{data}" width="{width}" height="{height}" type="application/pdf">\n';
    var tOther = '<div class="kv-preview-data file-preview-other-frame">\n' + DEFAULT_PREVIEW + '\n</div>\n';

    $.fn.fileinputThemes.mytheme = {
        fileActionSettings: {
            removeIcon: '<i class="fa fa-trash text-danger"></i>',
            uploadIcon: '<i class="fa fa-upload text-info"></i>',
            zoomIcon: '<i class="fa fa-search-plus"></i>',
            dragIcon: '<i class="fa fa-bars"></i>',
            indicatorNew: '<i class="fa fa-hand-o-down text-warning"></i>',
            indicatorSuccess: '<i class="fa fa-check-circle text-success"></i>',
            indicatorError: '<i class="fa fa-exclamation-circle text-danger"></i>',
            indicatorLoading: '<i class="fa fa-hand-o-up text-muted"></i>'
        },
        layoutTemplates: {
            preview: '<div class="file-preview {class}">\n' +
            '    {close}' +
            '    <div class="{dropClass}">\n' +
            '    <div class="file-preview-thumbnails">\n' +
            '    </div>\n' +
            '    <div class="clearfix"></div>' +
            '    <div class="file-preview-status text-center text-success"></div>\n' +
            '    <div class="kv-fileinput-error"></div>\n' +
            '    </div>\n' +
            '</div>',
            footer: '<td class="file-details-cell"><div class="explorer-caption" title="{caption}">{caption}</div> ' +
            '{size}{progress}</td><td class="file-actions-cell">{actions}</td>',
            actions: '<div class="file-upload-indicator" title="{indicatorTitle}">{indicator}</div>\n' +
            '{drag}\n' +
            '<div class="file-actions">\n' +
            '    <div class="file-footer-buttons">\n' +
            '        {delete} {zoom}' +
            '    </div>\n' +
            '</div>',
            zoomCache: '<tr style="display:none" class="kv-zoom-cache-theme"><td>' +
            '<table class="kv-zoom-cache">{zoomContent}</table></td></tr>',
            fileIcon: '<i class="fa fa-file kv-caption-icon"></i> '
        },
        previewTemplates:{
            generic: tTagBef1 + tGeneric + tTagAft,
            html: tTagBef1 + tHtml + tTagAft,
            image: tTagBef1 + tImage + tTagAft,
            text: tTagBef1 + tText + tTagAft,
            video: tTagBef2 + tVideo + tTagAft,
            audio: tTagBef2 + tAudio + tTagAft,
            flash: tTagBef2 + tFlash + tTagAft,
            object: tTagBef2 + tObject + tTagAft,
            pdf: tTagBef2 + tPdf + tTagAft,
            other: tTagBef2 + tOther + tTagAft
        },
        previewZoomButtonIcons: {
            prev: '<i class="fa fa-caret-left fa-lg"></i>',
            next: '<i class="fa fa-caret-right fa-lg"></i>',
            toggleheader: '<i class="fa fa-arrows-v"></i>',
            fullscreen: '<i class="fa fa-arrows-alt"></i>',
            borderless: '<i class="fa fa-external-link"></i>',
            close: '<i class="fa fa-remove"></i>'
        },
        previewFileIcon: '<i class="fa fa-file"></i>',
        browseIcon: '<i class="fa fa-folder-open"></i>',
        removeIcon: '<i class="fa fa-trash"></i>',
        cancelIcon: '<i class="fa fa-ban"></i>',
        uploadIcon: '<i class="fa fa-upload"></i>',
        msgValidationErrorIcon: '<i class="fa fa-exclamation-circle"></i> '
    };
})(window.jQuery);
