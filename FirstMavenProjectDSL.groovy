job('First_Maven_Project_DSL')
{
	description("First maven project via DSL")
	scm
	{
		github('https://github.com/Saba-Perween/2nd-git-repo.git', 'dev')
	}
	triggers
	{
		scm('* * * * *')
	}
	steps
	{
		maven('clean package', 'webprojectapi/pom.xml')
	}
	publisher
	{
		archiveArtifacts '**/*.war'
	}
}
