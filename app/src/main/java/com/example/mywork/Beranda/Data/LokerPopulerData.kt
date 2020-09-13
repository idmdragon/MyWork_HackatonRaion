package com.example.mywork.Beranda.Data

import com.example.mywork.Beranda.Model.LokerModel
import com.example.mywork.R

object LokerPopulerData {
    private val pekerjaan = arrayOf(
        "IT Development Staff",
        "Senior Digital Marketing",
        "IT Project Manager"
    )

    private val logo_perusahaan = intArrayOf(R.drawable.mitracomm, R.drawable.talent, R.drawable.faspay)

    private val perusahaan = arrayOf(
        "MitraComm",
        "PT Talenta Sumber Daya Manusia",
        "Faspay"
    )

    private val tempat = arrayOf(
        "Jakarta Selatan, Indonesia",
        "Bekasi, Depok, Tangerang, Jakarta Raya",
        "Jakarta Pusat"
    )

    private val gaji_min = doubleArrayOf(5.5,3.5,7.0)

    private val gaji_max = doubleArrayOf(6.5,5.0,14.0)

    private val detail_loker = arrayOf(
        "a. Warga Negara Indonesia (WNI)\n" +
            "b. Minimal pendidikan D3 dan diutamakan S1 lulusan Informatika/Teknik Elektro/MIS ataupun sejenisnya.\n" +
            "c. IPK min. 2.75\n" +
            "d. Usia max 30 tahun .\n" +
            "e. Menguasai basis data.\n" +
            "f. Menguasai setidaknya salah satu dari pemrograman ini: Visual Basic, ASP, C#\n" +
            "g. Diprioritaskan yang sudah memiliki pengalaman.",
        "-",
        "Find and coordinate with external vendors\n" +
                "Create a plan and processes to monitor and report project progress\n" +
                "Communicate progress with management\n" +
                "Communicate effectively with clients to ensure they remain satisfied\n" +
                "Create and maintain project documentation\n" +
                "Ensure that projects are finished on time and under budget\n" +
                "Conduct risk management processes to reduce company risk\n" +
                "Manage internal resources\n" +
                "Manage workload across team\n" +
                "Measure project performance using appropriate tools and techniques\n" +
                "Report and escalate to management as needed\n" +
                "Manage the relationship with the client and all stakeholders\n" +
                "Perform risk management to minimize project risks\n" +
                "Establish and maintain relationships with third parties/vendors\n" +
                "Create and maintain comprehensive project documentation"
    )

    private val syarat_loker = arrayOf(
        "a. Warga Negara Indonesia (WNI)\n" +
                "b. Minimal pendidikan D3 dan diutamakan S1 lulusan Informatika/Teknik Elektro/MIS ataupun sejenisnya.\n" +
                "c. IPK min. 2.75\n" +
                "d. Usia max 30 tahun .\n" +
                "e. Menguasai basis data.\n" +
                "f. Menguasai setidaknya salah satu dari pemrograman ini: Visual Basic, ASP, C#\n" +
                "g. Diprioritaskan yang sudah memiliki pengalaman.",
        "Male/Female\n" +
                "Preferred from reputable university\n" +
                "Having experience in Digital Marketing min 5 years\n" +
                "Understand the concept of SEO, UI / UX\n" +
                "Experienced in improving Website\n" +
                "Experienced in developing Inhouse Website\n" +
                "Experienced working in an agency\n" +
                "Willing to work at South Jakarta\n",
        "Candidate must possess at least Bachelor's Degree in Engineering (Computer/Telecommunication) or equivalent.\n" +
                "At least 2 Year(s) of working experience in the related field is required for this position (Fresh Graduate are welcome to apply).\n" +
                "Preferably Staff (non-management & non-supervisor) specialized in Project Manager or equivalent.\n" +
                "Experience working in an Agile/Scrum development process\n" +
                "Excellent communication skills\n" +
                "Attentention to detail\n" +
                "Analytical mind and problem solving aptitude\n" +
                "Strong organizational skills\n" +
                "Technical management skills\n" +
                "Technical understanding including hardware, software, network, infrastructure, security, etc.\n" +
                "Ability to analyze information and gleam insights from data\n" +
                "Good at informing others and at communicating with many different teams\n" +
                "Capable of staffing many different roles\n" +
                "Excellent at problem solving\n" +
                "Strong data center management skills\n" +
                "Advanced resource planning, capacity planning and task scheduling skills")

    private val tipe = arrayOf("Full Time", "Full Time", "Full Time")

    private val bidang = arrayOf("IT / MIS, Programmer", "Internet Marketing", "IT")

    private val batas_daftar = arrayOf("06 Oktober 2020", "02 Oktober 2020", "01 Oktober 2020")

    private val email_daftar = arrayOf("-@mitracomm.com", "talent@talent.com", "faspay@faspay.com")

    private val telp_daftar = arrayOf("+62215731313", "+62217462839", "081274628394")

    val listData: ArrayList<LokerModel>
        get(){
            var list = arrayListOf<LokerModel>()
            for(position in pekerjaan.indices){
                var loker = LokerModel(
                    pekerjaan[position],
                    logo_perusahaan[position],
                    perusahaan[position],
                    tempat[position],
                    gaji_min[position],
                    gaji_max[position],
                    detail_loker[position],
                    syarat_loker[position],
                    tipe[position],
                    bidang[position],
                    batas_daftar[position],
                    email_daftar[position],
                    telp_daftar[position],
                )
                list.add(loker)
            }
            return list
        }
}