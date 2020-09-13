package com.example.mywork.Beranda.Data

import com.example.mywork.Beranda.Model.LokerModel
import com.example.mywork.R

object LokerRekomendasiData {
    private val pekerjaan = arrayOf(
        "Web Programmer",
        "Android Engineer",
        "Engineering Manager","IT Development Staff",
        "Senior Digital Marketing",
        "IT Project Manager"
    )

    private val logo_perusahaan = intArrayOf(R.drawable.tokopedia, R.drawable.gojek, R.drawable.gojek, R.drawable.mitracomm, R.drawable.talent, R.drawable.faspay)

    private val perusahaan = arrayOf(
        "Tokopedia",
        "Gojek",
        "Gojek", "MitraComm",
        "PT Talenta Sumber Daya Manusia",
        "Faspay"
    )

    private val tempat = arrayOf(
        "Jakarta, Indonesia",
        "Jakarta, Indonesia",
        "Bandung, Jawa Barat", "Jakarta Selatan, Indonesia",
        "Bekasi, Depok, Tangerang, Jakarta Raya",
        "Jakarta Pusat"
    )

    private val gaji_min = doubleArrayOf(2.0,1.5,1.0, 5.5,3.5,7.0)

    private val gaji_max = doubleArrayOf(3.0,3.0,2.0, 6.5,5.0,14.0)

    private val detail_loker = arrayOf(
        "Provide technical leadership in a fast-moving, data-driven environment. You will be deeply engaged in the full development lifecycle designing, developing, testing, deploying, maintaining, monitoring and improving software. You will deploy code daily and use data to drive our decisions, while delivering software and analytics to consumers and dealers.",
        "You will be joining a great mobile team that will move the product based on metrics. Challenging the PM about what product being built is also part of it. Implementing tech excellence in mobile from the code up to CI/CD and any other aspect related to mobile development.",
        "Engineering Manager is the first formal leadership role in Gojek engineering organization. As an Engineering Manager, you will be accountable to lead a team of 5 - 10 engineers. To excel in this role, we believe you will need to have excellent ability in prioritization and tactical recommendation making along with deep technical expertise and eagerness to take a hands-on approach as necessary in delivering values for the customers. Also, it’s equally important to be passionate in taking care of the growth and development of the team."
    ,"a. Warga Negara Indonesia (WNI)\n" +
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
        "1. B.S. degree in Computer Science or related field (preferred)\n" +
                "2. 1+ years of software development experience\n" +
                "3. Expertise with Java or similar object-oriented languages\n" +
                "4. Strong understanding of MySQL or similar relational databases\n" +
                "5. Understanding of how to build high volume, distributed back-end services with latest technologies\n" +
                "6. Experienced with a modern Javascript framework like React.js is a plus\n" +
                "7. Experienced with building scalable websites (e-commerce) or large-scale applications\n" +
                "8. Possess strong debugging skills.",
        "1. Experienced in building end-to-end system, preferably with large user base\n" +
                "2. Experienced in working with app and software design\n" +
                "3. Experienced in working with native app\n" +
                "4. Deep understanding of Android framework\n" +
                "5. Experience developing in Kotlin\n" +
                "6. Attention to detail, particularly around software engineering fundamentals, testing methodologies, and quality\n" +
                "7. Have deep knowledge in UI/UX design to make exceptional consumer-facing apps interfaces\n" +
                "8. Familiar with several Design Patterns\n" +
                "9. Familiar with engineering culture such as pair programming, TDD, CI/CD",
        "1. Engineers typically acquire the skills, knowledge, and experience necessary to meet the expectations of this role with at least 7 years of relevant industry experience\n" +
                "2. Have experience in managing and mentoring a team of direct reports\n" +
                "3. Well-versed with Agile methodologies, best practices of writing tests and Continuous Integration / Continuous Delivery\n" +
                "4. Is hands-on and enjoys writing code\n" +
                "5. Have experience in developing end-to-end products across mobile and backend at scale\n" +
                "6. Excellent written & verbal communication skills focused on improving collaboration, knowledge and information exchange across all stakeholders",
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

    private val tipe = arrayOf("Full Time", "Full Time", "Full Time", "Full Time", "Full Time", "Full Time")

    private val bidang = arrayOf("IT", "IT", "IT", "IT / MIS, Programmer", "Internet Marketing", "IT")

    private val batas_daftar = arrayOf("20 September 2020", "30 September 2020", "25 September 2020", "06 Oktober 2020", "02 Oktober 2020", "01 Oktober 2020")

    private val email_daftar = arrayOf("tokped@tokopedia.com", "gojek@gojek.com", "gojek@gojek.com", "-@mitracomm.com", "talent@talent.com", "faspay@faspay.com")

    private val telp_daftar = arrayOf("081273528639", "081274628394", "081274628394", "+62215731313", "+62217462839", "081274628394")

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