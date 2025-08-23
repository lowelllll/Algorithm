# 백준이나 프로그래머스에 있는 내용을 토대로 알고리즘 문제 풀이 파일을 만듬
import requests
from bs4 import BeautifulSoup 
import tomd

class AlgorithmMd():
	SITE = {
		'백준': {
			'name': 'backjoon',
			'base_url': 'https://www.acmicpc.net/problem/'
		},
		'프로그래머스' : {'name': 'programmers'} # 프로그래머스의 문제 url은 일정하지 않기때문에 따로 입력 필요 
	}

	def __init__(self, site, q_num, lang, type):
		self.site = site
		self.q_num = q_num
		self.lang = lang
		self.path = './{lang}/[{site}] {qname}.md'
		self.type = type

	def question_to_md(self):
		with open('template.md', 'r') as template_md:
			template = template_md.read()

		data = self.question_crawler()

		template = template.format(
			q_num=self.q_num,
			lang=self.lang,
			site=AlgorithmMd.SITE[self.site]['name'],
			q_name=data['title'],
			type=self.type,
			question=data['problem_description'],
			input=data['problem_input'],
			output=data['problem_output'],
			sample_input=data['sample_input'],
			sample_output=data['sample_output']
		)

		path = './{lang}/[{site}] {title}.md'.format(lang=self.lang, site=self.site, title=data['title'])

		with open(path, 'w') as f:
			f.write(template)

		print('저장했습니다.')

	def question_crawler(self):
		url = AlgorithmMd.SITE[self.site]['base_url'] + str(self.q_num)
		res = requests.get(url)
		soup = BeautifulSoup(res.text, 'html.parser')

		title = soup.select('#problem_title')[0].string

		problem_description = soup.select('#problem_description')[0]
		org_image = problem_description.find('img')

		problem_description = tomd.Tomd(str(problem_description)).markdown

		problem_image = None

		if org_image:
			problem_image_src = org_image['src']
			problem_image = self.image_to_md(problem_image_src, title)
			print(org_image)
			print(problem_image)
			problem_description = problem_description.replace(str(org_image), problem_image)

		problem_input = soup.select('#problem_input')[0]
		problem_input = tomd.Tomd(str(problem_input)).markdown

		problem_output = soup.select('#problem_output')[0]
		problem_output = tomd.Tomd(str(problem_output)).markdown

		sample_input= soup.find_all(id='sample-input-1')[0].get_text()
		# sample_input = tomd.Tomd(str(sample_input)).markdown

		sample_output = soup.find_all(id='sample-output-1')[0].get_text()
		# sample_output = tomd.Tomd(str(sample_output)).markdown

		data = {
			'title': title,
			'problem_description': problem_description,
			'problem_input': problem_input,
			'problem_output': problem_output,
			'sample_input': sample_input,
			'sample_output': sample_output
		}

		print(data)
		return data

	def image_to_md(self, src, alt):
		return '![{alt}]({src})'.format(alt=alt, src=src)

if __name__ == '__main__':
	am = AlgorithmMd('백준', 1004, 'java', 'DFS')
	am.question_to_md()