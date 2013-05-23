DESCRIPTION = "Midori X session files for poky"
HOMEPAGE = "http://www.yoctoproject.org"
BUGTRACKER = "http://bugzilla.pokylinux.org"

PR = "r0"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

SECTION = "x11"
RCONFLICTS_${PN} = "matchbox-common"

SRC_URI = "file://slider-session \
           file://config \
           file://lc_demo/* \
          "
S = "${WORKDIR}"

inherit update-alternatives

BROWSER="midori"
USER="root"

ALTERNATIVE_${PN} = "x-session-manager"
ALTERNATIVE_TARGET[x-session-manager] = "${bindir}/slider-session"
ALTERNATIVE_PRIORITY = "50"

do_install() {
        install -d ${D}/${bindir}
        install -m 0755 ${S}/slider-session ${D}/${bindir}
        install -d ${D}/home/${USER}/lc-demo
#        install -m 0644 ${WORKDIR}/lc_demo/* ${D}/home/${USER}/lc-demo/
        cp -r ${WORKDIR}/lc_demo/* ${D}/home/${USER}/lc-demo/
        chmod -R 644 ${D}/home/${USER}/lc-demo/
}

FILES_${PN} += "/home/${USER}/lc-demo/*"
