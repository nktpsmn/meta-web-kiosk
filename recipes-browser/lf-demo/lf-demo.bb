DESCRIPTION = "Midori X session files for poky"
HOMEPAGE = "http://www.yoctoproject.org"
BUGTRACKER = "http://bugzilla.pokylinux.org"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

SRC_URI = "file://lf_demo/*"

S = "${WORKDIR}"

USER = "root"
RDEPENDS_${PN}=" gst-plugins-base-playbin "

do_install() {
	install -d ${D}/home/${USER}
        cp -r ${WORKDIR}/lf_demo ${D}/home/${USER}
        chmod -R 644 ${D}/home/${USER}/lf_demo/
}

FILES_${PN} += "/home/${USER}/lf_demo"
